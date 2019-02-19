package sep.jql.interfaces.converter;

import sep.jql.interfaces.request.Request;
import sep.jql.interfaces.statement.query.QueryStatement;

public interface SQLConverter {

    String generateQuerySQL(QueryStatement queryStatement);

    String generateQuerySQL(QueryStatement queryStatement, Request request);

}
