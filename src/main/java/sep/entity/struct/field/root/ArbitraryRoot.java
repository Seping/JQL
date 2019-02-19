package sep.entity.struct.field.root;

import sep.entity.struct.field.attribute.ArbitraryAttribute;
import sep.entity.struct.field.attribute.Attribute;

public class ArbitraryRoot {
    public Attribute<?> getAttribute(String attributeName) {
        return new ArbitraryAttribute();
    }
}
