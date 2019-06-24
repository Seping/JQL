package sep.jql.impls.statement.condition;

import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;

public class JQLSingleConditionExpression implements SingleConditionExpression {

    private Condition condition;

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toSQLString() {
        return condition.toSQLString();
    }

    @Override
    public CompositeConditionExpression compositize() {
        CompositeConditionExpression compositeConditionExpression = new JQLCompositeConditionExpression();
        compositeConditionExpression.addConditionExpression(this);
        return compositeConditionExpression;
    }
}
