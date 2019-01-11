package sep.entity.struct.field.special;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.BasicField;
import sep.entity.struct.field.Field;
import sep.jql.Attribute;

import java.util.function.BiConsumer;

public class Tombstone<E> extends BasicField<E, Integer> {
    public Tombstone(Entity<E> entity, String columnName, Attribute<E> attribute, BiConsumer<E, Integer> fieldValueSetter) {
        super(entity, columnName, Integer.class, attribute, fieldValueSetter);
    }

    @Override
    public Integer getInsertValue() {
        return 0;
    }

    @Override
    public Integer getQueryValue() {
        return 0;
    }

    @Override
    public Integer getTombstoneValue() {
        return 1;
    }
}
