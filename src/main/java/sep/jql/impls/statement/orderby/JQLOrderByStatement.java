package sep.jql.impls.statement.orderby;

import sep.jql.interfaces.statement.orderby.OrderByExpression;
import sep.jql.interfaces.statement.orderby.OrderByStatement;

public class JQLOrderByStatement implements OrderByStatement {

    private OrderByExpression orderByExpression;

    @Override
    public void setOrderByExpression(OrderByExpression orderByExpression) {
        this.orderByExpression = orderByExpression;
    }

    @Override
    public String toSQLString() {
        return "ORDER BY " + orderByExpression.toSQLString();
    }
}
