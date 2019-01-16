package sep.entity.struct.field.special;

import sep.entity.struct.field.BasicField;

public class Tombstone<E> extends BasicField<E, Integer> {

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
