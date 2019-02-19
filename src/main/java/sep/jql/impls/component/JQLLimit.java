package sep.jql.impls.component;

import sep.jql.impls.statement.limit.JQLLimitExpression;
import sep.jql.impls.statement.limit.JQLLimitStatement;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.statement.limit.LimitExpression;
import sep.jql.interfaces.statement.limit.LimitStatement;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLLimit<M> implements Limit<M> {

    public JQLLimit(QueryStatement queryStatement, Integer offset, Integer rowCount) {
        LimitExpression limitExpression = new JQLLimitExpression(offset, rowCount);

        LimitStatement limitStatement = new JQLLimitStatement();
        limitStatement.setLimitExpression(limitExpression);

        queryStatement.setLimitStatement(limitStatement);
    }

}
