package sep.jql.interfaces.request.handler;

import sep.jql.interfaces.request.Request;
import sep.jql.interfaces.statement.Statement;

public interface RequestHandler<S extends Statement, R extends Request> {

    void handle(S statement, R request);

}
