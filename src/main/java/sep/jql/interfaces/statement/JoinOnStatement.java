package sep.jql.interfaces.statement;

public interface JoinOnStatement extends Statement {

    void setJoinStatement(JoinStatement joinStatement);

    void setOnStatement(OnStatement onStatement);

}
