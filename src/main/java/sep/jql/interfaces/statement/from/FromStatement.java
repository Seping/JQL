package sep.jql.interfaces.statement.from;

import sep.jql.interfaces.statement.Statement;

public interface FromStatement extends Statement {

    FromExpression getFromExpression();

}
