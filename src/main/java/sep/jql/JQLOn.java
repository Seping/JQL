package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.able.*;
import sep.jql.condition.ConditionChain;
import sep.jql.condition.DoubleAttributeSpecification;
import sep.jql.condition.SingleAttributeSpecification;

public class JQLOn<M, A, B> extends SQLConvertibleChain implements On<M, A, B> {

    Class<A> rootClass;
    Class<B> joinClass;
    JQLConditionChain conditionChain;

    public JQLOn(Class<A> rootClass, Class<B> joinClass, DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {
        this.rootClass = rootClass;
        this.joinClass = joinClass;

        Root<A> root1 = new Root<>();
        Root<B> root2 = new Root<>();
        conditionChain = new JQLConditionChain();

        doubleAttributeSpecification.specific(root1, root2, conditionChain);
    }

    @Override
    public <C, D> Onable<M, C, D> join(Class<C> rootClass, Class<D> joinClass) {
        return setNextAndReturn(new JQLJoin<>(rootClass, joinClass));
    }

    @Override
    public OrderByable<M> where(SingleAttributeSpecification<M> singleAttributeSpecification) {
        return setNextAndReturn(new JQLWhere<>(singleAttributeSpecification));
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
        return "\r\n\tON " + conditionChain.toSQLStringChain();
    }
}
