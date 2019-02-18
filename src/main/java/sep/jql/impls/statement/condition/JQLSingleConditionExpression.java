package sep.jql.impls.statement.condition;

import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.condition.LogicalOperator;
import sep.jql.interfaces.statement.condition.ConditionExpression;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;

public class JQLSingleConditionExpression implements SingleConditionExpression {

    private Condition condition;

    @Override
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
