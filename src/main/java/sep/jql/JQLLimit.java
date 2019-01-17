package sep.jql;

import sep.jql.able.Limit;

public class JQLLimit<M> implements Limit<M> {

    Integer offset;
    Integer rowCount;

    public JQLLimit(Integer offset, Integer rowCount) {
        this.offset = offset;
        this.rowCount = rowCount;
    }

    @Override
    public JQLStatement<M> end() {
        return null;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
