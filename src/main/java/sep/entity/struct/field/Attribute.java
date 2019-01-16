package sep.entity.struct.field;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.sql.SQLConvertible;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface Attribute<T> extends Serializable, SQLConvertible {

    Object get(T t);

    default SerializedLambda serialized() {
        try {
            Method replaceMethod = this.getClass().getDeclaredMethod("writeReplace");
            replaceMethod.setAccessible(true);
            return (SerializedLambda) replaceMethod.invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    default String toSQLString() {
        SerializedLambda serializedLambda = this.serialized();
        Entity entity = EntityRepository.getEntityByClassName(serializedLambda.getImplClass().replaceAll("/", "."));
        Field field = entity.getFieldByAttributeName(serializedLambda.getImplMethodName());
        String tableName = entity.toSQLString();
        String columnName = field.toSQLString();
        return tableName + "." + columnName;
    }
}
