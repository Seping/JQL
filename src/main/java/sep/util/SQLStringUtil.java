package sep.util;

import sep.entity.struct.field.attribute.Attribute;
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

    public static String underscoreCaseToCamelCase(String underscoreCase, boolean initialCapitalization) {
        int basicLength = underscoreCase.length();
        char[] chars = new char[basicLength];
        char firstLetter = underscoreCase.charAt(0);
        chars[0] = (firstLetter >= 'a' && firstLetter <= 'z' && initialCapitalization) ? (char) (firstLetter - 32) : firstLetter;
        for (int i = 1, j = 1; i < basicLength; i++, j++) {
            if (underscoreCase.charAt(i) == '_') {
                if (i != basicLength - 1) {
                    i++;
                    chars[j] = (char) (underscoreCase.charAt(i) - 32);
                }
            } else {
                chars[j] = underscoreCase.charAt(i);
            }
        }
        return String.valueOf(chars);
    }
}
