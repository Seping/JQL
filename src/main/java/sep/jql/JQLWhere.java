package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.able.Limit;
import sep.jql.able.Limitable;
import sep.jql.able.OrderByable;
import sep.jql.able.SingleJoinable;
import sep.jql.condition.ConditionChain;
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
    public JQLStatement<M> end() {
        return null;
    }

    @Override
    public String toSQLString() {
        return "\r\nWHERE " + conditionChain.toSQLStringChain();
    }
}
