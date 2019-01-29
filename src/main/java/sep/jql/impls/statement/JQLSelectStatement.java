package sep.jql.impls.statement;

import sep.jql.interfaces.statement.SelectExprStatement;
import sep.jql.interfaces.statement.SelectStatement;

public class JQLSelectStatement implements SelectStatement {

    SelectExprStatement selectExprStatement;
    final String operator = "SELECT";

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public void setOperand(SelectExprStatement selectExprStatement) {
        this.selectExprStatement = selectExprStatement;
    }

    @Override
    public SelectExprStatement getOperand() {
        return selectExprStatement;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
