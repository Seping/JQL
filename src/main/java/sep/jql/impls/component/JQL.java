package sep.jql.impls.component;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.field.Attribute;
import sep.jql.impls.statement.JQLFromStatement;
import sep.jql.impls.statement.JQLSelectStatement;
import sep.jql.impls.statement.JQLStatement;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.From;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.condition.SingleAttributeSpecification;
import sep.jql.interfaces.statement.FromStatement;
import sep.jql.interfaces.statement.QueryStatement;
import sep.jql.interfaces.statement.SelectStatement;

public class JQL<M> implements From<M> {

    private QueryStatement queryStatement;

    private Class<M> mainClass;

    private JQL(QueryStatement queryStatement, Class<M> fromClass) {
        this.queryStatement = queryStatement;
        this.mainClass = fromClass;
    }

    public static <M> JQL<M> from(Class<M> fromClass) {

        QueryStatement queryStatement = new JQLStatement();

        SelectStatement selectStatement = new JQLSelectStatement();
        selectStatement.getOperand().addSelectEntity(fromClass);
        queryStatement.setSelectStatement(selectStatement);

        FromStatement fromStatement = new JQLFromStatement();
        fromStatement.setOperand(EntityRepository.getEntity(fromClass));
        queryStatement.setFromStatement(fromStatement);

        return new JQL<M>(queryStatement, fromClass);
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
        return new JQLJoin<>(queryStatement, mainClass, joinClass);
    }

    @Override
    public OrderByable<M> where(SingleAttributeSpecification<M> singleAttributeSpecification) {
        return null;
    }
}
