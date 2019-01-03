package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.Entity;
import sep.entity.struct.Field;
import sep.entity.struct.Id;
import sep.util.SQLStringUtil;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class JQLExecutor {

    public static <T> List<ComplexEntity<?>> execute(JQLStatement<T> jqlStatement, Connection connection) {
        JQL<T> jql = jqlStatement.jql;
        try {
            PreparedStatement singlePreparedStatement = connection.prepareStatement(SQLCreator.createSQL(jqlStatement));
            ResultSet resultSet = singlePreparedStatement.executeQuery();
            List<ComplexEntity<?>> complexEntities = new ArrayList<>();
            List<Class> order = getInstantiateOrder(jql);
            while (resultSet.next()) {
                getEntityFromResultSet(resultSet, complexEntities, order);
            }

            resultSet.close();
            singlePreparedStatement.close();
            connection.close();

            return complexEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static <T> List<Entity> getEntities(JQL<T> jql) {
        List<Entity> entities = new ArrayList<>();
        entities.add(EntityRepository.getByClass(jql.mainClass));
        entities.addAll(
                jql.joins
                        .stream()
                        .map(singleJoin -> EntityRepository.getByClass(singleJoin.joinClass))
                        .collect(Collectors.toList())
        );
        return entities;
    }

    private static List<Class> getInstantiateOrder(JQL<?> jql) {
        List<Class> classes = new ArrayList<>();
        classes.add(jql.mainClass);

        Deque<Join> deque = new ArrayDeque<>();
        deque.addAll(jql.joins);
        while (deque.size() > 0) {
            Join join = deque.poll();
            if (!classes.contains(join.joinClass)) {
                classes.add(join.joinClass);
            }
        }
        return classes;
    }

    private static void getEntityFromResultSet(ResultSet resultSet, List<ComplexEntity<?>> complexEntities, List<Class> classOrder) throws SQLException {
        for (int i = 0, size = classOrder.size(); i < size; i++) {
            Class clazz = classOrder.get(i);
            Entity<?> entity = EntityRepository.getByClass(clazz);
            Id idField = entity.getIdField();
            Integer id = (Integer) SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + idField.getColumnName()), Integer.class);
            if (id == null) {
                continue;
            }
            Optional<ComplexEntity<?>> complexEntityOptional = complexEntities.stream().filter(ce -> id.equals(idField.getValue(ce.mainEntity))).findFirst();
            ComplexEntity<?> complexEntity;
            if (!complexEntityOptional.isPresent()) {
                Object t = entity.newInstance();
                for (Field field : entity.getFields()) {
                    field.setValue(t, SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + field.getColumnName()), field.getType()));
                }
                complexEntity = new ComplexEntity<>(t);
                complexEntities.add(complexEntity);
            } else {
                complexEntity = complexEntityOptional.get();
            }
            if (i < size - 1) {
                complexEntities = complexEntity.joinMap.computeIfAbsent(classOrder.get(i + 1), key -> new ArrayList<>());
            }
        }

    }

}
