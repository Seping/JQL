package sep.util;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;

import java.util.Collection;

public class SQLStringUtil {

    public static String toSQLValueString(Object object) {
        if (object == null) {
            return "NULL";
        }
        if (object instanceof Attribute) {
            return ((Attribute) object).toSQLString();
        }
        if (object instanceof String) {
            return "'" + object + "'";
        }
        return String.valueOf(object);
    }

    public static <T> T stringToSQLValue(String valueString, Class<T> clazz) {
        if (valueString == null) {
            return null;
        }
        if (clazz.equals(Integer.class)) {
            return (T) Integer.valueOf(valueString);
        }
        if (clazz.equals(String.class)) {
            return (T) valueString;
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
