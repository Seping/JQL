package sep.jql.impls.statement.limit;

import sep.jql.interfaces.statement.limit.LimitExpression;

public class JQLLimitExpression implements LimitExpression {

    private Integer offset;
    private Integer rowCount;

    public JQLLimitExpression(Integer offset, Integer rowCount) {
        this.offset = offset;
        this.rowCount = rowCount;
    }

    @Override
    public String toSQLString() {
        return offset + ", " + rowCount;
    }
}
