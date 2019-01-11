package sep.entity.struct.field;

import sep.entity.struct.entity.Entity;
import sep.jql.Attribute;

import java.util.function.BiConsumer;

public class BasicField<E, V> implements Field<E, V> {

    protected Entity<E> entity;
    protected String columnName;
    protected Class<V> valueType;

    protected Attribute<E> attribute;
    protected BiConsumer<E, V> fieldValueSetter;

    public BasicField(Entity<E> entity, String columnName, Class<V> valueType, Attribute<E> attribute, BiConsumer<E, V> fieldValueSetter) {
        this.entity = entity;
        this.columnName = columnName;
        this.valueType = valueType;
        this.attribute = attribute;
        this.fieldValueSetter = fieldValueSetter;
    }

    @Override
    public final Entity<E> getEntity() {
        return entity;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }

    @Override
    public final Class<V> getValueType() {
        return valueType;
    }

    @Override
    public final V getValue(E e) {
        return (V) attribute.get(e);
    }

    @Override
    public final void setValue(E e, V v) {
        fieldValueSetter.accept(e, v);
    }

    @Override
    public final Attribute<E> getAttribute() {
        return attribute;
    }

    @Override
    public V getUpdateValue() {
        return null;
    }

    @Override
    public V getInsertValue() {
        return null;
    }

    @Override
    public V getQueryValue() {
        return null;
    }

    @Override
    public V getTombstoneValue() {
        return null;
    }
}
