package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.impls.statement.orderby.JQLOrderByExpression;
import sep.jql.impls.statement.orderby.JQLOrderByStatement;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.order.Order;
import sep.jql.interfaces.statement.orderby.OrderByExpression;
import sep.jql.interfaces.statement.orderby.OrderByStatement;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLOrderBy<M> implements Limitable<M> {

    private QueryStatement queryStatement;

    public JQLOrderBy(QueryStatement queryStatement, Attribute<M> attribute, Order order) {
        this.queryStatement = queryStatement;

        OrderByExpression orderByExpression = new JQLOrderByExpression(attribute, order);

        OrderByStatement orderByStatement = new JQLOrderByStatement();
        orderByStatement.setOrderByExpression(orderByExpression);

        queryStatement.setOrderByStatement(orderByStatement);
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return new JQLLimit<>(queryStatement, offset, rowCount);
    }

}
