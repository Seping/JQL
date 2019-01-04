package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Id;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SQLCreator {

    private static String createQuerySQL(JQL jql) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        createAlias(jql, sql);
        sql.append("\r\n");
        sql.append("FROM " + EntityRepository.getByClass(jql.mainClass).getTableNameWithQuote());
        List<Join> joins = jql.joins;
        for (Join join : joins) {
            sql.append("\r\n");
            sql.append(join.toString());
        }
        if (jql.where != null) {
            sql.append("\r\n");
            sql.append(jql.where.toString());
        }
        if (jql.orderBy != null) {
            sql.append("\r\n");
            sql.append(jql.orderBy.toString());
        }
        if (jql.limit != null) {
            sql.append("\r\n");
            sql.append(jql.limit.toString());
        }
        return sql.toString();
    }

    public static String createQuerySQL(JQLStatement jqlStatement) {
        return createQuerySQL(jqlStatement.jql);
    }

    private static void createAlias(JQL<?> jql, StringBuffer sql) {
        List<Entity> entities = new ArrayList<>();
        entities.add(EntityRepository.getByClass(jql.mainClass));
        for (Join join : jql.joins) {
            entities.add(EntityRepository.getByClass(join.joinClass));
        }

        for (Entity<?> entity : entities) {
            for (Field field : entity.getFields()) {
                sql.append(entity.getTableNameWithQuote());
                sql.append(".");
                sql.append(field.getColumnNameWithQuote());
                sql.append(" AS ");
                sql.append("'");
                sql.append(entity.getTableName());
                sql.append(".");
                sql.append(field.getColumnName());
                sql.append("', ");
            }
        }

        sql.deleteCharAt(sql.lastIndexOf(","));
    }

    public static <T> String createUpdateSQL(Entity<T> entity, List<T> elementsWithId) {

        if (elementsWithId.size() == 0) { return null; }
        //TODO
        List<Field> normalFields = entity.getFields()
                .stream()
                .filter(field -> !(field instanceof Id) &&
                                    !field.getColumnName().equals("sys_i_status") &&
                                    !field.getColumnName().equals("sys_i_create_user") &&
                                    !field.getColumnName().equals("sys_dt_last_update") &&
                                    !field.getColumnName().equals("sys_i_last_update_user") &&
                                    !field.getColumnName().equals("sys_i_status"))
                .collect(Collectors.toList());

        Field lastUpdateTimestamp = entity.getFields()
                .stream()
                .filter(field -> field.getColumnName().equals("sys_dt_last_update"))
                .findFirst()
                .get();
        Field lastUpdateUser = entity.getFields()
                .stream()
                .filter(field -> field.getColumnName().equals("sys_i_last_update_user"))
                .findFirst()
                .get();

        StringBuffer stringBuffer = new StringBuffer();
        //UPDATE table_name
        stringBuffer.append("UPDATE " + entity.getTableNameWithQuote() + " \n\r");
        //SET normal_fields
        stringBuffer.append("\tSET");
        for (Field normalField : normalFields) {
            stringBuffer.append(normalField.getColumnName() + " = CASE " + entity.getIdField().getColumnName() + "\n\r");
            for (T model : elementsWithId) {
                stringBuffer.append("\t\tWHEN " + entity.getIdField().getValue(model) + " THEN " + normalField.getValue(model) + "\n\r");
            }
            stringBuffer.append("\tEND, \n\r\t");
        }
        //SET update_timestamp
        stringBuffer.append(lastUpdateTimestamp.getColumnName() + " = " + new Date(System.currentTimeMillis()));
        stringBuffer.append(", \n\r\t");
        //SET last_update_user
        /*stringBuffer.append(getColumn(modelHelper.getLastUpdateUser()) + " = " + getDefaultValue(modelHelper.getLastUpdateUser()));
        stringBuffer.append(", \n\r\t");*/
        //WHERE
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(", "));
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("\t"));
        stringBuffer.append("WHERE " + entity.getIdField().getColumnName() + " IN (" + concatFieldValues(elementsWithId, entity.getIdField()) + ")");

        return stringBuffer.toString();
    }

    private static String concatFieldValues(List<?> elements, Field field) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0, size = elements.size(); i < size; i++) {
            stringBuffer.append(field.getValue(elements.get(i)));
            if (i != size - 1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    public static <T> String createInsertSQL(Entity<T> entity, List<T> elementsWithoutId) {
        //TODO
        return null;
    }
}
