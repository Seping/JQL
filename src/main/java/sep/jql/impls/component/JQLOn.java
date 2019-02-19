package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.impls.statement.condition.JQLCompositeConditionExpression;
import sep.jql.impls.statement.joinon.JQLOnStatement;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.component.On;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;
import sep.jql.interfaces.condition.SingleAttributeSpecification;
import sep.jql.interfaces.order.Order;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.joinon.OnStatement;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLOn<M, A, B> implements On<M, A, B> {

    private QueryStatement queryStatement;

    private Class<A> rootClass;
    private Class<B> joinClass;

    JQLOn(QueryStatement queryStatement, Class<A> rootClass, Class<B> joinClass, DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {

        this.queryStatement = queryStatement;

        this.rootClass = rootClass;
        this.joinClass = joinClass;

        CompositeConditionExpression compositeConditionExpression = new JQLCompositeConditionExpression();

        Root<A> root1 = new Root<>();
        Root<B> root2 = new Root<>();
        ConditionBuilder conditionBuilder = new JQLConditionBuilder(compositeConditionExpression);

        doubleAttributeSpecification.specific(root1, root2, conditionBuilder);

        OnStatement onStatement = new JQLOnStatement();
        onStatement.setConditionExpression(compositeConditionExpression);

        queryStatement.getJoinOnStatements().getLast().setOnStatement(onStatement);

    }

    @Override
    public <A, B> Onable<M, A, B> join(Class<A> rootClass, Class<B> joinClass) {
        return new JQLJoin<>(queryStatement, rootClass, joinClass);
    }

    @Override
    public OrderByable<M> where(SingleAttributeSpecification<M> singleAttributeSpecification) {
        return new JQLWhere<>(queryStatement, singleAttributeSpecification);
    }

    @Override
    public Limitable<M> orderBy(Attribute<M> attribute, Order order) {
        return new JQLOrderBy<>(queryStatement, attribute, order);
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return new JQLLimit<>(queryStatement, offset, rowCount);
    }
}
