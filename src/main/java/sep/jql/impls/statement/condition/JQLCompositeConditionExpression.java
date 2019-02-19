package sep.jql.impls.statement.condition;

import sep.jql.interfaces.condition.LogicalOperator;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.condition.ConditionExpression;

public class JQLCompositeConditionExpression implements CompositeConditionExpression {

    private LogicalOperator logicalOperator;
    private ConditionExpression[] conditionExpressions = new ConditionExpression[2];

    @Override
    public void addConditionExpression(ConditionExpression conditionExpression) {
        if (conditionExpressions[0] == null) {
            conditionExpressions[0] = conditionExpression;
        } else if (conditionExpressions[1] == null) {
            conditionExpressions[1] = conditionExpression;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void connectConditionExpression(LogicalOperator logicalOperator) {
        if (this.logicalOperator != null) {
            throw new IllegalStateException();
        } else {
            if (isComplete()) {
                reborn();
            } else if (isEmpty()) {
                //do nothing
            } else {
                this.logicalOperator = logicalOperator;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return conditionExpressions[0] == null && conditionExpressions[1] == null;
    }

    @Override
    public boolean isComplete() {
        return conditionExpressions[0] != null && conditionExpressions[1] != null;
    }

    private void reborn() {
        JQLCompositeConditionExpression newExpression = new JQLCompositeConditionExpression();
        newExpression.logicalOperator = logicalOperator;
        newExpression.conditionExpressions[0] = conditionExpressions[0];
        newExpression.conditionExpressions[1] = conditionExpressions[1];

        conditionExpressions[0] = newExpression;
        conditionExpressions[1] = null;
    }

    @Override
    public String toSQLString() {
        return logicalOperator == null ?
                conditionExpressions[0].toSQLString() :
                conditionExpressions[0].toSQLString() + "\r\n\t\t" + logicalOperator.toSQLString() + " " + conditionExpressions[1].toSQLString();
    }
}
