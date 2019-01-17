package sep.jql;

import sep.jql.condition.ComparisonOperator;

public enum JQLComparisionOperator implements ComparisonOperator {

    EQUAL("="),
    NOTEQUAL("!="),
    GREATER(">"),
    LESS("<"),
    GREATER_OR_EQUAL(">="),
    LESS_OR_EQUAL("<=");

    private String operator;
    JQLComparisionOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
