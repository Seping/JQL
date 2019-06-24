package sep.jql.impls.statement.joinon;

import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.joinon.JoinStatement;
import sep.jql.interfaces.statement.joinon.OnStatement;

public class JQLJoinOnStatement implements JoinOnStatement {

    private JoinStatement joinStatement;
    private OnStatement onStatement;

    @Override
    public JoinStatement getJoinStatement() {
        return joinStatement;
    }

    @Override
    public OnStatement getOnStatement() {
        return onStatement;
    }

    @Override
    public void setJoinStatement(JoinStatement joinStatement) {
        this.joinStatement = joinStatement;
    }

    @Override
    public void setOnStatement(OnStatement onStatement) {
        this.onStatement = onStatement;
    }

    @Override
    public String toSQLString() {
        return "\t" + joinStatement.toSQLString() + "\r\n\t" + onStatement.toSQLString();
    }
}
