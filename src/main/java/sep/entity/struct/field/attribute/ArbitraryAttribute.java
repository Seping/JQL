package sep.entity.struct.field.attribute;

import sep.entity.struct.entity.Entity;

public class ArbitraryAttribute implements Attribute {

    String attributeName;

    Attribute attribute;

    public ArbitraryAttribute(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public Object get(Object o) {
        return attribute.get(o);
    }

    public Attribute getAttributeByEntity(Entity<?> entity) {
        return entity.getAttributeByName(attributeName);
    }
}
