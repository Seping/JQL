package sep.entity.struct.field.special;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.BasicField;
import sep.entity.struct.field.Field;
import sep.jql.Attribute;

import java.sql.Timestamp;
import java.util.function.BiConsumer;

public class CreateTimestamp<E> extends BasicField<E, Timestamp> {

    @Override
    public Timestamp getInsertValue() {
        return new Timestamp(System.currentTimeMillis());
    }
}
