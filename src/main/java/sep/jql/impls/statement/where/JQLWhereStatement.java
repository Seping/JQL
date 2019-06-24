package sep.jql.impls.statement.where;

import sep.jql.interfaces.statement.condition.ConditionExpression;
import sep.jql.interfaces.statement.where.WhereStatement;

public class JQLWhereStatement implements WhereStatement {

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
        return "WHERE " + conditionExpression.toSQLString();
    }
}
