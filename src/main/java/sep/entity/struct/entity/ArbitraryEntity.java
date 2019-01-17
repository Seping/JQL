package sep.entity.struct.entity;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;

import java.util.List;

public class ArbitraryEntity implements Entity {

    private Entity entity;

    @Override
    public Class getEntityType() {
        return entity.getEntityType();
    }

    @Override
    public String getTableName() {
        return entity.getTableName();
    }

    @Override
    public List<Field> getFields() {
        return entity.getFields();
    }

    @Override
    public Field getFieldByAttributeName(String attributeName) {
        return entity.getFieldByAttributeName(attributeName);
    }

    @Override
    public Attribute getAttribute(Attribute attribute) {
        return entity.getAttribute(attribute);
    }

    @Override
    public Attribute getAttributeByName(String attributeName) {
        return entity.getAttributeByName(attributeName);
    }

    @Override
    public void addField(Field field) {
        entity.addField(field);
    }

    @Override
    public Object newInstance() {
        return entity.newInstance();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toSQLString() {
        return entity.toSQLString();
    }
}
