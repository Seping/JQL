package sep.entity.struct.entity;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Tombstone;
import sep.sql.SQLConvertible;

import java.util.List;
import java.util.function.Supplier;

public interface Entity<T> extends SQLConvertible {

    Class<T> getEntityType();

    String getTableName();

    List<Field<T, ?>> getFields();

    void addField(Field<T, ?> field);

    Field<T, ?> getFieldByAttributeName(String attributeName);

    Attribute<T> getAttribute(Attribute<T> attribute);

    Attribute<T> getAttributeByName(String attributeName);

    T newInstance();

}
