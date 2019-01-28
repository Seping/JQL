package sep.jql.impls.component;

import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.condition.LogicalOperator;

public class JQLConditionConjunction extends SQLConvertibleChain implements ConditionConjunction {

    LogicalOperator logicalOperator;

    @Override
    public ConditionBuilder and() {
        this.logicalOperator = JQLLogicalOperator.AND;
        return setNextAndReturn(new JQLConditionBuilder());
    }

    @Override
    public ConditionBuilder or() {
        this.logicalOperator = JQLLogicalOperator.OR;
        return setNextAndReturn(new JQLConditionBuilder());
    }

    @Override
    public String toSQLString() {
        return logicalOperator == null ? "" : "\r\n\t\t" + logicalOperator.toSQLString() + " ";
    }
}
