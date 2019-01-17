package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.jql.able.*;
import sep.jql.condition.SingleAttributeSpecification;

public class JQL<M> extends SQLConvertibleChain implements SingleJoinable<M>, Whereable<M> {

    Class<M> mainClass;

    private JQL(Class<M> mainClass) {
        this.mainClass = mainClass;
    }

    public static <M> JQL<M> from(Class<M> fromClass) {
        return new JQL<>(fromClass);
    }

    @Override
    public <B> Onable<M, M, B> join(Class<B> joinClass) {
        return setNextAndReturn(new JQLJoin<>(mainClass, joinClass));
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
        return null;
    }
}
