package sep.jql.interfaces.request;

import sep.jql.interfaces.statement.Statement;

public interface Request {

    void setTarget(Statement statement);

    Statement request();
}
