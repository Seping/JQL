package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.impls.statement.condition.JQLCompositeConditionExpression;
import sep.jql.impls.statement.condition.JQLSingleConditionExpression;
import sep.jql.interfaces.condition.ComparisonOperator;
import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.condition.ConditionExpression;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;

public class JQLConditionBuilder implements ConditionBuilder {

    CompositeConditionExpression compositeConditionExpression;

    JQLConditionBuilder(CompositeConditionExpression compositeConditionExpression) {
        this.compositeConditionExpression = compositeConditionExpression;
    }

    @Override
    public ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    @Override
    public ConditionConjunction notEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.NOTEQUAL);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    @Override
    public ConditionConjunction greater(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    @Override
    public ConditionConjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER_OR_EQUAL);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    @Override
    public ConditionConjunction less(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.LESS);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    @Override
    public ConditionConjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.LESS_OR_EQUAL);
        return new JQLConditionConjunction(compositeConditionExpression);
    }

    private void createCondition(Attribute<?> leftAttribute, Object rightAttribute, ComparisonOperator comparisonOperator) {
        Condition condition = new JQLCondition<>(leftAttribute, rightAttribute, comparisonOperator);
        SingleConditionExpression singleConditionExpression = new JQLSingleConditionExpression();
        singleConditionExpression.setCondition(condition);
        compositeConditionExpression.addConditionExpression(singleConditionExpression);
    }

}
