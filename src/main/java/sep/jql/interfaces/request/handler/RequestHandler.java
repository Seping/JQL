package sep.jql.interfaces.request.handler;

import sep.jql.interfaces.request.Request;
import sep.jql.interfaces.statement.Statement;

public interface RequestHandler {

    Statement handle(Request request);

}
