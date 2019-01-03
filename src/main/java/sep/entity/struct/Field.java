package sep.entity.struct;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 实体类里的成员抽象。
 */
public class Field {

    private String columnName;
    private Class type;
    private String getterName;
    private FieldValueGetter fieldValueGetter;
    private BiConsumer fieldValueSetter;

    public Field(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameWithQuote() {
        return "`" + columnName + "`";
    }

    public void setFieldValueGetter(FieldValueGetter fieldValueGetter) {
        this.fieldValueGetter = fieldValueGetter;
    }

    public void setFieldValueSetter(BiConsumer fieldValueSetter) {
        this.fieldValueSetter = fieldValueSetter;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getGetterName() {
        return getterName;
    }

    public void setGetterName(String getterName) {
        this.getterName = getterName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getValue(Object entity) {
        return fieldValueGetter.getValue(entity);
    }

    public void setValue(Object t, Object value) {
        fieldValueSetter.accept(t, value);
    }
}
