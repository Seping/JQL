package sep.jql.interfaces.statement.limit;

import sep.jql.interfaces.statement.Statement;

public interface LimitStatement extends Statement {
    void setLimitExpression(LimitExpression limitExpression);
}
