package sep.jql.impls.request.page.handler;

import sep.jql.impls.statement.limit.JQLLimitExpression;
import sep.jql.impls.statement.limit.JQLLimitStatement;
import sep.jql.interfaces.request.handler.RequestHandler;
import sep.jql.interfaces.request.page.PageRequest;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLPageRequestHandler implements RequestHandler<QueryStatement, PageRequest> {

    @Override
    public void handle(QueryStatement queryStatement, PageRequest pageRequest) {
        if (queryStatement.getLimitStatement() == null) {
            queryStatement.setLimitStatement(new JQLLimitStatement());
        }
        queryStatement.getLimitStatement().setLimitExpression(new JQLLimitExpression(pageRequest.getOffset(), pageRequest.getRowCount()));
    }

}
