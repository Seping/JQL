package sep.jql.impls.statement.select;

import sep.jql.interfaces.statement.select.SelectExpression;
import sep.jql.interfaces.statement.select.SelectStatement;

public class JQLSelectStatement implements SelectStatement {

    private SelectExpression selectExpression = new JQLSelectExpression();

    @Override
    public SelectExpression getSelectExpression() {
        return selectExpression;
    }

    @Override
    public String toSQLString() {
        return "SELECT " + selectExpression.toSQLString();
    }
}
