package sep.entity.struct.field.factory;

import sep.entity.struct.field.Field;

import java.lang.reflect.InvocationTargetException;

public class FieldFactory {

    public static Field createField(Class<?> fieldClass) {
        try {
            return (Field) fieldClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Field createField(String fieldClassName) {
        try {
            Class<?> fieldClass = Class.forName(fieldClassName);
            return createField(fieldClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
