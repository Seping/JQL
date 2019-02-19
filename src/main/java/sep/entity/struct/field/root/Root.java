package sep.entity.struct.field.root;

import sep.entity.struct.field.attribute.Attribute;

public class Root<T> {
    public Attribute<T> getAttribute(Attribute<T> attribute) {
        return attribute;
    }
}
