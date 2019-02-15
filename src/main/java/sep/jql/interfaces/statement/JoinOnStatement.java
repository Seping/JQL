package sep.jql.interfaces.statement;

import sep.jql.interfaces.statement.basic.Statement;

public interface JoinOnStatement extends Statement {

    void setJoinStatement(JoinStatement joinStatement);

    void setOnStatement(OnStatement onStatement);

}
