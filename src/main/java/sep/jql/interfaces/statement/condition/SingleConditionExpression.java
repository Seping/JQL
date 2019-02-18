package sep.jql.interfaces.statement.condition;

import sep.jql.interfaces.condition.Condition;

public interface SingleConditionExpression extends ConditionExpression {
    void setCondition(Condition condition);
}
