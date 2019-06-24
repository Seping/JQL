package sep.entity.struct.entity;

import sep.entity.struct.field.attribute.Attribute;
import sep.entity.struct.field.Field;
import sep.sql.SQLConvertible;

import java.util.List;

public interface Entity<T> extends SQLConvertible {

    Class<T> getEntityType();

    String getTableName();

    List<Field<T, ?>> getFields();

    void addField(Field<T, ?> field);

    Field<T, ?> getFieldByAttributeName(String attributeName);

    <F extends Field<T, ?>> F getFieldByFieldType(Class<?> fieldType);

    Attribute<T> getAttribute(Attribute<T> attribute);

    Attribute<T> getAttributeByName(String attributeName);

    T newInstance();

}
