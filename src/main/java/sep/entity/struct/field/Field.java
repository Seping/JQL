package sep.entity.struct.field;

import sep.entity.struct.entity.Entity;
import sep.jql.Attribute;

import java.lang.invoke.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * the abstraction of entity's field.
 *
 * @author Sep
 * @param <E> the type of concrete entity
 * @param <V> the type of field value
 */
public interface Field<E, V> {

    /**
     * Set the entity abstraction which it belongs.
     */
    void setEntity(Entity<E> entity);

    /**
     * Get the entity abstraction which it belongs.
     */
    Entity<E> getEntity();

    /**
     * Set the name of column which it maps.
     */
    void setColumnName(String columnName);

    /**
     * Get the name of column which it maps.
     */
    String getColumnName();

    /**
     * Set the type of value.
     */
    void setValueType(Class<V> valueType);

    /**
     * Get the type of value.
     */
    Class<V> getValueType();

    /**
     * Get the value of one concrete entity.
     */
    V getValue(E e);

    /**
     * Set the value of this field of one concrete entity.
     */
    void setValue(E e, V v);

    /**
     * Set the corresponding {@code Attribute}.
     */
    void setAttribute(Attribute<E> attribute);

    /**
     * Get the corresponding {@code Attribute}.
     */
    Attribute<E> getAttribute();

    /**
     * Get the value using in update.
     * If the return value is not null,
     * then this return value will be used in the update statement
     * instead of the value of the field itself.
     */
    V getUpdateValue();

    /**
     * Get the value using in insert.
     * If the return value is not null,
     * then this return value will be used in the insert statement
     * instead of the value of the field itself.
     */
    V getInsertValue();

    /**
     * Get the value using in query.
     * Specify the value of the field to be equal
     * to the return value when executing query.
     */
    V getQueryValue();

    /**
     * Get the value using in logically delete.
     * Set the value of the field to the return value
     * when executing logically delete.
     */
    V getTombstoneValue();

}
