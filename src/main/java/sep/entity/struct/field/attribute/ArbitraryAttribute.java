package sep.entity.struct.field.attribute;

public class ArbitraryAttribute implements Attribute {

    Attribute attribute;

    @Override
    public Object get(Object o) {
        return attribute.get(o);
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
