package sep.jql.impls.statement.condition;

import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;

public class JQLSingleConditionExpression implements SingleConditionExpression {

    private Condition condition;

    @Override
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toSQLString() {
        return condition.toSQLString();
    }
}
