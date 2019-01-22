package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.jql.component.Limit;
import sep.jql.able.Limitable;

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
