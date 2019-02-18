package sep.jql.interfaces.statement.condition;

import sep.jql.interfaces.condition.LogicalOperator;

public interface CompositeConditionExpression extends ConditionExpression {

    void addConditionExpression(ConditionExpression conditionExpression);

    void connectConditionExpression(LogicalOperator logicalOperator);

    boolean isEmpty();

    boolean isComplete();

}
