package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;

public interface JoinOnStatement extends Statement {

    void setJoinStatement(JoinStatement joinStatement);

    void setOnStatement(OnStatement onStatement);

}
