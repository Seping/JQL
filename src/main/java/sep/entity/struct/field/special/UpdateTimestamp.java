package sep.entity.struct.field.special;

import com.sun.tools.corba.se.idl.constExpr.Times;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.BasicField;
import sep.entity.struct.field.Field;
import sep.jql.Attribute;

import java.sql.Timestamp;
import java.util.function.BiConsumer;

public class UpdateTimestamp<E> extends BasicField<E, Timestamp> {

    public UpdateTimestamp(Entity<E> entity, String columnName, Attribute<E> attribute, BiConsumer<E, Timestamp> fieldValueSetter) {
        super(entity, columnName, Timestamp.class, attribute, fieldValueSetter);
    }

    @Override
    public Timestamp getUpdateValue() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Timestamp getInsertValue() {
        return new Timestamp(System.currentTimeMillis());
    }
}
