package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.jql.condition.ComparisonOperator;
import sep.jql.condition.Condition;
import sep.jql.condition.ConditionChain;
import sep.jql.condition.ConditionConjunction;
import sep.sql.SQLConvertible;

import java.util.ArrayList;
import java.util.List;

public class JQLConditionChain extends SQLConvertibleChain implements ConditionChain {

    Condition<?> condition;

    @Override
    public ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute) {
        condition = new JQLCondition<>(leftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
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
