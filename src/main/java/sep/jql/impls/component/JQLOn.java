package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.able.*;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.component.On;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;
import sep.jql.interfaces.condition.SingleAttributeSpecification;

public class JQLOn<M, A, B> extends SQLConvertibleChain implements On<M, A, B> {

    Class<A> rootClass;
    Class<B> joinClass;
    JQLConditionBuilder conditionChain;

    public JQLOn(Class<A> rootClass, Class<B> joinClass, DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {
        this.rootClass = rootClass;
        this.joinClass = joinClass;

        Root<A> root1 = new Root<>();
        Root<B> root2 = new Root<>();
        conditionChain = new JQLConditionBuilder();

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
    public String toSQLString() {
        return "\r\n\tON " + conditionChain.toSQLStringChain();
    }
}
