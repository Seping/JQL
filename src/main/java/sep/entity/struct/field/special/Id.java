package sep.entity.struct.field.special;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.BasicField;
import sep.jql.Attribute;

import java.util.function.BiConsumer;

public class Id<E> extends BasicField<E, Integer> {

    public Id(Entity<E> entity, String columnName, Attribute<E> attribute, BiConsumer<E, Integer> fieldValueSetter) {
        super(entity, columnName, Integer.class, attribute, fieldValueSetter);
    }

}
