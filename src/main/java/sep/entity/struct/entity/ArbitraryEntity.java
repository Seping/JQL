package sep.entity.struct.entity;

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
}
