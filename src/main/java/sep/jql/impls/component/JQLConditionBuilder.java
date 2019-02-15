package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.statement.ConditionArrayStatement;

public class JQLConditionBuilder implements ConditionBuilder {

    private ConditionArrayStatement conditionCollectionStatement;

    public JQLConditionBuilder(ConditionArrayStatement conditionCollectionStatement) {
        this.conditionCollectionStatement = conditionCollectionStatement;
    }

    @Override
    public ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute) {
        Condition condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
        
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public ConditionConjunction notEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.NOTEQUAL);
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public ConditionConjunction greater(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER);
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public ConditionConjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER_OR_EQUAL);
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public ConditionConjunction less(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.LESS);
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public ConditionConjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.LESS_OR_EQUAL);
        return setNextAndReturn(new JQLConditionConjunction());
    }

    @Override
    public String toSQLString() {
        return condition.toSQLString();
    }
}
