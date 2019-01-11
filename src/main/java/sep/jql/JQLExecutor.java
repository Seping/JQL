package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Field;
import sep.jql.connection.ConnectionFactory;
import sep.util.SQLStringUtil;

import java.sql.*;
import java.util.*;

public class JQLExecutor {

    public static <T> List<ComplexEntity<T>> executeQuery(JQLStatement<T> jqlStatement) {
        JQL<T> jql = jqlStatement.jql;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement singlePreparedStatement = connection.prepareStatement(SQLCreator.createQuerySQL(jqlStatement));
            ResultSet resultSet = singlePreparedStatement.executeQuery();
            List<ComplexEntity<T>> complexEntities = new ArrayList<>();
            List<Class> order = getInstantiateOrder(jql);
            while (resultSet.next()) {
                getComplexEntityFromResultSet(resultSet, complexEntities, order);
            }

            /*resultSet.close();
            singlePreparedStatement.close();
            connection.close();*/

            return complexEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
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

    private static <T> void getComplexEntityFromResultSet(ResultSet resultSet, List<ComplexEntity<T>> complexEntities, List<Class> classOrder) throws SQLException {
        for (int i = 0, size = classOrder.size(); i < size; i++) {
            Class clazz = classOrder.get(i);
            Entity<?> entity = EntityRepository.getByClass(clazz);
            Id idField = entity.getIdField();
            Integer id = (Integer) SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + idField.getColumnName()), Integer.class);
            if (id == null) {
                continue;
            }
            Optional complexEntityOptional = complexEntities.stream().filter(ce -> id.equals(idField.getValue(ce.mainEntity))).findFirst();
            ComplexEntity complexEntity;
            if (!complexEntityOptional.isPresent()) {
                Object t = entity.newInstance();
                for (Field field : entity.getFields()) {
                    field.setValue(t, SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + field.getColumnName()), field.getType()));
                }
                complexEntity = new ComplexEntity<>(t);
                complexEntities.add(complexEntity);
            } else {
                complexEntity = (ComplexEntity) complexEntityOptional.get();
            }
            if (i < size - 1) {
                complexEntities = (List<ComplexEntity<T>>) complexEntity.joinMap.computeIfAbsent(classOrder.get(i + 1), key -> new ArrayList<>());
            }
        }

    }

    public static <T> Collection<T> executeSave(Collection<T> collection, Class<T> type) {

        Entity<T> entity = EntityRepository.getByClass(type);

        List<Integer> indexesWithoutId = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<T> elementsWithId = new ArrayList<>();
        List<T> elementsWithoutId = new ArrayList<>();

        int i = 0;
        for (T t : collection) {
            Integer id = (Integer) entity.getIdField().getValue(t);
            ids.add(id);
            if (id != null) {
                elementsWithId.add(t);
            } else {
                indexesWithoutId.add(i);
                elementsWithoutId.add(t);
            }
            i++;
        }

        String updateSQL = SQLCreator.createUpdateSQL(entity, elementsWithId);
        String insertSQL = SQLCreator.createInsertSQL(entity, elementsWithoutId);

        Connection connection = ConnectionFactory.getConnection();
        List<Integer> insertIds = new ArrayList<>();
        try {
            if (updateSQL != null) {
                PreparedStatement updateStatement = connection.prepareStatement(updateSQL, Statement.RETURN_GENERATED_KEYS);
                updateStatement.executeUpdate();
            }

            if (insertSQL != null) {
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
                insertStatement.executeUpdate();
                ResultSet idResultSet = insertStatement.getGeneratedKeys();
                while (idResultSet.next()) {
                    insertIds.add(idResultSet.getInt(1));
                }
            }


            //TODO: is ArrayList the best struct?
            i = 0;
            for (Integer indexWithoutId : indexesWithoutId) {
                ids.set(indexWithoutId, insertIds.get(i));
                i++;
            }

            //query again
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + entity.getTableNameWithQuote() + " WHERE " + entity.getIdField().getColumnNameWithQuote() + " IN " + SQLStringUtil.concatValueInBrackets(ids));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                T t = entity.newInstance();
                for (Field field : entity.getFields()) {
                    field.setValue(t, SQLStringUtil.stringToSQLValue(resultSet.getString(entity.getTableName() + "." + field.getColumnName()), field.getType()));
                }
                result.add(t);
            }
            collection.clear();
            collection.addAll(result);
            return collection;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


    }
}
