package sep.entity.struct.entity;

import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Tombstone;

import java.util.List;
import java.util.function.Supplier;

public interface Entity<T> {

    Class<T> getEntityType();

    String getTableName();

    List<Field<T, ?>> getFields();

    void addField(Field<T, ?> field);

    T newInstance();

}
