package sep.jql.interfaces.statement.select;

import sep.jql.interfaces.statement.Statement;

public interface SelectStatement extends Statement {

    SelectExpression getSelectExpression();

}
