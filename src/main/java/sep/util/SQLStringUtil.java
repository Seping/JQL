package sep.util;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.Entity;
import sep.entity.struct.Field;
import sep.jql.Attribute;

import java.lang.invoke.SerializedLambda;

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

}
