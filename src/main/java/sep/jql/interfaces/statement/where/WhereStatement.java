package sep.jql.interfaces.statement.where;

import sep.jql.interfaces.statement.Statement;
import sep.jql.interfaces.statement.condition.ConditionExpression;

public interface WhereStatement extends Statement {
    void setConditionExpression(ConditionExpression conditionExpression);
}
