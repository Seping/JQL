package sep.jql.interfaces.statement.orderby;

import sep.jql.interfaces.statement.Statement;

public interface OrderByStatement extends Statement {
    void setOrderByExpression(OrderByExpression orderByExpression);
}
