package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.Entity;
import sep.entity.struct.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLCreator {

    private static String createSQL(JQL jql) {
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

    public static String createSQL(JQLStatement jqlStatement) {
        return createSQL(jqlStatement.jql);
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

}
