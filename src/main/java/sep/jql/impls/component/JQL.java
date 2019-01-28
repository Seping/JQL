package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.From;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.condition.SingleAttributeSpecification;

public class JQL<M> implements From<M> {

    Class<M> mainClass;

    private JQL(Class<M> mainClass) {
        this.mainClass = mainClass;
    }

    public static <M> JQL<M> from(Class<M> fromClass) {
        return new JQL<>(fromClass);
    }

    @Override
    public Limitable<M> orderBy(Attribute<M> attribute) {
        return null;
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return null;
    }

    @Override
    public <B> Onable<M, M, B> join(Class<B> joinClass) {
        return null;
    }

    @Override
    public OrderByable<M> where(SingleAttributeSpecification<M> singleAttributeSpecification) {
        return null;
    }
}
