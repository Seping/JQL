package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.impls.statement.JQLStatement;
import sep.jql.impls.statement.from.JQLFromStatement;
import sep.jql.impls.statement.select.JQLSelectStatement;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.From;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.condition.SingleAttributeSpecification;
import sep.jql.interfaces.order.Order;
import sep.jql.interfaces.statement.from.FromStatement;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.jql.interfaces.statement.select.SelectStatement;

public class JQL<M> implements From<M> {
    //TODO: should be private
    public QueryStatement queryStatement;

    private Class<M> mainClass;

    private JQL(QueryStatement queryStatement, Class<M> fromClass) {
        this.queryStatement = queryStatement;
        this.mainClass = fromClass;
    }

    public static <M> JQL<M> from(Class<M> fromClass) {

        QueryStatement queryStatement = new JQLStatement();

        SelectStatement selectStatement = new JQLSelectStatement();
        selectStatement.getSelectExpression().addEntity(fromClass);
        queryStatement.setSelectStatement(selectStatement);

        FromStatement fromStatement = new JQLFromStatement();
        fromStatement.getFromExpression().setEntity(fromClass);

        queryStatement.setFromStatement(fromStatement);

        return new JQL<M>(queryStatement, fromClass);
    }

    @Override
    public <B> Onable<M, M, B> join(Class<B> joinClass) {
        return new JQLJoin<>(queryStatement, mainClass, joinClass);
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
