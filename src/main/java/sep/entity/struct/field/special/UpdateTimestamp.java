package sep.entity.struct.field.special;


import sep.entity.struct.field.BasicField;

import java.sql.Timestamp;

public class UpdateTimestamp<E> extends BasicField<E, Timestamp> {

    @Override
    public Timestamp getUpdateValue() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Timestamp getInsertValue() {
        return new Timestamp(System.currentTimeMillis());
    }
}
