package sep.jql.impls.component;

import sep.entity.resolver.EntityRepository;
import sep.jql.impls.statement.JQLJoinOnStatement;
import sep.jql.impls.statement.JQLJoinStatement;
import sep.jql.interfaces.component.On;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;
import sep.jql.interfaces.statement.JoinOnStatement;
import sep.jql.interfaces.statement.JoinStatement;
import sep.jql.interfaces.statement.QueryStatement;

public class JQLJoin<M, A, B> implements Onable<M, A, B> {

    private QueryStatement queryStatement;

    private Class<A> rootClass;
    private Class<B> joinClass;

    JQLJoin(QueryStatement queryStatement, Class<A> rootClass, Class<B> joinClass) {

        this.rootClass = rootClass;
        this.joinClass = joinClass;

        this.queryStatement = queryStatement;

        JoinStatement joinStatement = new JQLJoinStatement();
        joinStatement.setOperand(EntityRepository.getEntity(joinClass));

        JoinOnStatement joinOnStatement = new JQLJoinOnStatement();
        joinOnStatement.setJoinStatement(joinStatement);

        queryStatement.getJoinOnCollectionStatement().add(joinOnStatement);

    }

    @Override
    public On<M, A, B> on(DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {
        return new JQLOn<>(queryStatement, rootClass, joinClass, doubleAttributeSpecification);
    }
}
