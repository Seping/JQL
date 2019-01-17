package sep.jql;

import sep.jql.condition.ConditionChain;
import sep.jql.condition.ConditionConjunction;
import sep.jql.condition.LogicalOperator;

public class JQLConditionConjunction extends SQLConvertibleChain implements ConditionConjunction {

    LogicalOperator logicalOperator;

    @Override
    public ConditionChain and() {
        this.logicalOperator = JQLLogicalOperator.AND;
        return setNextAndReturn(new JQLConditionChain());
    }

    @Override
    public ConditionChain or() {
        this.logicalOperator = JQLLogicalOperator.OR;
        return setNextAndReturn(new JQLConditionChain());
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
