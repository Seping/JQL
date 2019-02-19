package sep.jql.impls.statement.joinon;

import sep.jql.interfaces.statement.joinon.JoinExpression;
import sep.jql.interfaces.statement.joinon.JoinStatement;

public class JQLJoinStatement implements JoinStatement {

    private JoinExpression joinExpression = new JQLJoinExpression();

    @Override
    public JoinExpression getJoinExpression() {
        return joinExpression;
    }

    @Override
    public String toSQLString() {
        return "JOIN " + joinExpression.toSQLString();
    }
}
