package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.able.Limitable;

public class JQLOrderBy<M> extends SQLConvertibleChain implements Limitable<M> {

    Attribute<M> attribute;

    public JQLOrderBy(Attribute<M> attribute) {
        this.attribute = attribute;
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return setNextAndReturn(new JQLLimit<>(offset, rowCount));
    }

    @Override
    public String toSQLString() {
        return "\r\nORDER BY " + attribute.toSQLString();
    }
}
