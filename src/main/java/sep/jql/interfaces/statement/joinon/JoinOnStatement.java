package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;

public interface JoinOnStatement extends Statement {

    JoinStatement getJoinStatement();

    OnStatement getOnStatement();

    void setJoinStatement(JoinStatement joinStatement);

    void setOnStatement(OnStatement onStatement);

}
