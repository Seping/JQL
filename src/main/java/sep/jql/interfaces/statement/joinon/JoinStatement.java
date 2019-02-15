package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;

public interface JoinStatement extends Statement {

    JoinExpression getJoinExpression();

}
