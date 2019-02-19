package sep.jql.impls.statement.from;

import sep.jql.interfaces.statement.from.FromExpression;
import sep.jql.interfaces.statement.from.FromStatement;

public class JQLFromStatement implements FromStatement {

    private FromExpression fromExpression = new JQLFromExpression();

    @Override
    public FromExpression getFromExpression() {
        return fromExpression;
    }

    @Override
    public String toSQLString() {
        return "FROM " + fromExpression.toSQLString();
    }
}
