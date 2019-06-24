package sep.jql.impls.statement.joinon;

import sep.jql.interfaces.statement.condition.ConditionExpression;
import sep.jql.interfaces.statement.joinon.OnStatement;

public class JQLOnStatement implements OnStatement {

    private ConditionExpression conditionExpression;

    @Override
    public ConditionExpression getConditionExpression() {
        return conditionExpression;
    }

    @Override
    public void setConditionExpression(ConditionExpression conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    @Override
    public String toSQLString() {
        return "ON " + conditionExpression.toSQLString();
    }
}
