package sep.entity.struct.field;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.value.FieldValueGetter;
import sep.jql.Attribute;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Field {

    private String columnName;
    private Class type;
    private String getterName;
    private FieldValueGetter fieldValueGetter;
    private BiConsumer fieldValueSetter;
    private Supplier defaultValueSupplier;

    public Field(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameWithQuote() {
        return "`" + columnName + "`";
    }
    public String getColumnName() {
        return columnName;
    }

    public void setFieldValueGetter(FieldValueGetter fieldValueGetter) {
        this.fieldValueGetter = fieldValueGetter;
    }
    public Object getValue(Object entity) {
        return fieldValueGetter.getValue(entity);
    }

    public void setFieldValueSetter(BiConsumer fieldValueSetter) {
        this.fieldValueSetter = fieldValueSetter;
    }
    public void setValue(Object t, Object value) {
        fieldValueSetter.accept(t, value);
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

    public void setDefaultValueSupplier(Supplier supplier) {
        this.defaultValueSupplier = supplier;
    }
    public Object getDefaultValue() {
        return defaultValueSupplier == null ? null : defaultValueSupplier.get();
    }

    /*public Attribute getAttribute(Entity entity, )*/

}
