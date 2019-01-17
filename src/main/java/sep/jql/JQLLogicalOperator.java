package sep.jql;

import sep.jql.condition.LogicalOperator;

public enum JQLLogicalOperator implements LogicalOperator {
    AND("&&"),
    OR("||");

    private String operator;
    JQLLogicalOperator(String operator){
        this.operator = operator;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}