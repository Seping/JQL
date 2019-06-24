package sep.jql.impls.executor;

import sep.connection.ConnectionFactory;
import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Id;
import sep.entity.struct.field.special.Tombstone;
import sep.jql.impls.component.JQLComparisionOperator;
import sep.jql.impls.component.JQLCondition;
import sep.jql.impls.component.JQLLogicalOperator;
import sep.jql.impls.result.JQLCompositeEntity;
import sep.jql.impls.statement.condition.JQLSingleConditionExpression;
import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;
import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.joinon.JoinStatement;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.result.CompositeEntity;
import sep.sql.SQLExecutor;
import sep.util.SQLStringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JQLExecutor implements SQLExecutor {

    @Override
    public <T> List<CompositeEntity<T>> executeQuery(QueryStatement queryStatement) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            preHandleQueryStatement(queryStatement);
            PreparedStatement singlePreparedStatement = connection.prepareStatement(queryStatement.toSQLString());
            ResultSet resultSet = singlePreparedStatement.executeQuery();
            List<CompositeEntity<T>> compositeEntities = new ArrayList<>();
            List<Class> order = getInstantiateOrder(queryStatement);
            while (resultSet.next()) {
                getComplexEntityFromResultSet(resultSet, compositeEntities, order);
            }

            /*resultSet.close();
            singlePreparedStatement.close();
            connection.close();*/

            return compositeEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void preHandleQueryStatement(QueryStatement queryStatement) {
        for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
            Entity<?> entity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
            Tombstone<?> tombstone = (Tombstone<?>) entity.getFieldByFieldType(Tombstone.class);
            Condition condition = new JQLCondition(tombstone.getAttribute(), tombstone.getQueryValue(), JQLComparisionOperator.EQUAL);
            SingleConditionExpression singleConditionExpression = new JQLSingleConditionExpression();
            singleConditionExpression.setCondition(condition);
            joinOnStatement.getOnStatement().getConditionExpression().compositize().connectConditionExpression(JQLLogicalOperator.AND);
            joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        Entity<?> entity = queryStatement.getFromStatement().getFromExpression().getEntity();
        Tombstone<?> tombstone = (Tombstone<?>) entity.getFieldByFieldType(Tombstone.class);
        Condition condition = new JQLCondition(tombstone.getAttribute(), tombstone.getQueryValue(), JQLComparisionOperator.EQUAL);
        SingleConditionExpression singleConditionExpression = new JQLSingleConditionExpression();
        singleConditionExpression.setCondition(condition);
        queryStatement.getWhereStatement().getConditionExpression().compositize().connectConditionExpression(JQLLogicalOperator.AND);
        queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
    }


    private static List<Class> getInstantiateOrder(QueryStatement queryStatement) {
        List<Class> classes = new ArrayList<>();
        classes.add(queryStatement.getFromStatement().getFromExpression().getEntity().getEntityType());

        Deque<JoinOnStatement> deque = new ArrayDeque<>();
        deque.addAll(queryStatement.getJoinOnStatements().getJoinOnStatementList());
        while (deque.size() > 0) {
            JoinOnStatement joinOnStatement = deque.poll();
            if (!classes.contains(joinOnStatement.getJoinStatement().getJoinExpression().getEntity().getEntityType())) {
                classes.add(joinOnStatement.getJoinStatement().getJoinExpression().getEntity().getEntityType());
            }
        }
        return classes;
    }

    private static <T> void getComplexEntityFromResultSet(ResultSet resultSet, List<CompositeEntity<T>> compositeEntities, List<Class> classOrder) throws SQLException {
        for (int i = 0, size = classOrder.size(); i < size; i++) {
            Class clazz = classOrder.get(i);
            Entity<?> entity = EntityRepository.getEntity(clazz);
            Id idField = entity.getFieldByFieldType(Id.class);
            Integer id = (Integer) SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + idField.getColumnName()), Integer.class);
            if (id == null) {
                continue;
            }
            Optional CompositeEntityOptional = compositeEntities.stream().filter(ce -> id.equals(idField.getValue(ce.getMainEntity()))).findFirst();
            CompositeEntity compositeEntity;
            if (!CompositeEntityOptional.isPresent()) {
                Object t = entity.newInstance();
                for (Field field : entity.getFields()) {
                    field.setValue(t, SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + field.getColumnName()), field.getValueType()));
                }
                compositeEntity = new JQLCompositeEntity<>(t);
                compositeEntities.add(compositeEntity);
            } else {
                compositeEntity = (CompositeEntity) CompositeEntityOptional.get();
            }
            if (i < size - 1) {
                compositeEntities = (List<CompositeEntity<T>>) compositeEntity.getJoinMap().computeIfAbsent(classOrder.get(i + 1), key -> new ArrayList<>());
            }
        }

    }

}
