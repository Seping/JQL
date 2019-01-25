package sep.jql.statement;

import sep.jql.request.Request;

public interface Statement {

    void handleRequest(Request<?> request);

}
