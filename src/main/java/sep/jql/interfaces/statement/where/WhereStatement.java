package sep.jql.interfaces.statement.where;

import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.statement.Statement;
import sep.jql.interfaces.statement.condition.ConditionExpression;

public interface WhereStatement extends Statement {

    ConditionExpression getConditionExpression();

    void setConditionExpression(ConditionExpression conditionExpression);
}
