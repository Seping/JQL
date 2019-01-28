package sep.jql.impls.component;

import sep.jql.interfaces.condition.LogicalOperator;

public enum JQLLogicalOperator implements LogicalOperator {
    AND("AND"),
    OR("OR");

    private String operator;
    JQLLogicalOperator(String operator){
        this.operator = operator;
    }

    @Override
    public String toSQLString() {
        return operator;
    }
}
