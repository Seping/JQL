package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;
import sep.jql.interfaces.statement.condition.ConditionExpression;

public interface OnStatement extends Statement {
    void setConditionExpression(ConditionExpression conditionExpression);
}
