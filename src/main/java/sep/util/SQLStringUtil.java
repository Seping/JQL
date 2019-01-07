package sep.util;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Field;
import sep.jql.Attribute;

import java.lang.invoke.SerializedLambda;
import java.util.Collection;

public class SQLStringUtil {

    public static String toSQLValueString(Object object) {
        if (object == null) {
            return "NULL";
        }
        if (object instanceof String) {
            return "'" + object + "'";
        }
        return String.valueOf(object);
    }

    public static String attribute2String(Attribute<?> attribute) {
        SerializedLambda serializedLambda = attribute.serialized();
        Entity entity = EntityRepository.getByClassName(serializedLambda.getImplClass().replaceAll("/", "."));
        Field field1 = entity.getFieldByGetterName(serializedLambda.getImplMethodName());
        String tableName1 = entity.getTableNameWithQuote();
        String columnName1 = field1.getColumnNameWithQuote();
        return tableName1 + "." + columnName1;
    }

    public static Object stringToSQLValue(String valueString, Class clazz) {
        if (valueString == null) {
            return null;
        }
        if (clazz.equals(Integer.class)) {
            return Integer.valueOf(valueString);
        }
        if (clazz.equals(String.class)) {
            return valueString;
        }
        return null;
    }

    public static <T> String concatFieldValueInBrackets(Collection<T> collection, Field field) {
        StringBuffer stringBuffer = new StringBuffer("(");
        for (T t : collection) {
            stringBuffer.append(toSQLValueString(field.getValue(t)));
            stringBuffer.append(", ");
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(" "));
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static <T> String concatValueInBrackets(Collection<T> collection) {
        StringBuffer stringBuffer = new StringBuffer("(");
        for (T t : collection) {
            stringBuffer.append(toSQLValueString(t));
            stringBuffer.append(", ");
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(" "));
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
