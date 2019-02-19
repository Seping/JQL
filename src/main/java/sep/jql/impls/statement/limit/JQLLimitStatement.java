package sep.jql.impls.statement.limit;

import sep.jql.interfaces.statement.limit.LimitExpression;
import sep.jql.interfaces.statement.limit.LimitStatement;

public class JQLLimitStatement implements LimitStatement {

    private LimitExpression limitExpression;

    @Override
    public void setLimitExpression(LimitExpression limitExpression) {
        this.limitExpression = limitExpression;
    }

    @Override
    public String toSQLString() {
        return "LIMIT " + limitExpression.toSQLString();
    }
}
