package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.able.*;
import sep.jql.component.Limit;
import sep.jql.condition.SingleAttributeSpecification;

public class JQLWhere<M> extends SQLConvertibleChain implements OrderByable<M> {

    JQLConditionChain conditionChain;

    public JQLWhere(SingleAttributeSpecification<M> singleAttributeSpecification) {
        Root<M> root = new Root<>();
        conditionChain = new JQLConditionChain();
        singleAttributeSpecification.specific(root, conditionChain);
    }

    @Override
    public Limitable<M> orderBy(Attribute<M> attribute) {
        return setNextAndReturn(new JQLOrderBy<>(attribute));
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return setNextAndReturn(new JQLLimit<>(offset, rowCount));
    }

    @Override
    public String toSQLString() {
        return "\r\nWHERE " + conditionChain.toSQLStringChain();
    }
}
