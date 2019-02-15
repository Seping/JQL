package sep.jql.interfaces.statement;

import sep.jql.interfaces.condition.LogicalOperator;
import sep.jql.interfaces.statement.basic.ArrayStatement;

public interface ConditionArrayStatement extends ArrayStatement<ArrayStatement> {

    void add(ArrayStatement arrayStatement, LogicalOperator logicalOperator);

}
