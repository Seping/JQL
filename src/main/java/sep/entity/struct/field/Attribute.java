package sep.entity.struct.field;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface Attribute<T> extends Serializable {

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
}
