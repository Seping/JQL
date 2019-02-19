package sep.jql.impls.component;

import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;

public class JQLConditionConjunction implements ConditionConjunction {

    private CompositeConditionExpression compositeConditionExpression;

    JQLConditionConjunction(CompositeConditionExpression compositeConditionExpression) {
        this.compositeConditionExpression = compositeConditionExpression;
    }

    @Override
    public ConditionBuilder and() {
        compositeConditionExpression.connectConditionExpression(JQLLogicalOperator.AND);
        return new JQLConditionBuilder(compositeConditionExpression);
    }

    @Override
    public ConditionBuilder or() {
        compositeConditionExpression.connectConditionExpression(JQLLogicalOperator.OR);
        return new JQLConditionBuilder(compositeConditionExpression);
    }
}
