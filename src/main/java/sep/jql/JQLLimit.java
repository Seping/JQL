package sep.jql;

import sep.jql.component.Limit;

public class JQLLimit<M> extends SQLConvertibleChain implements Limit<M> {

    Integer offset;
    Integer rowCount;

    public JQLLimit(Integer offset, Integer rowCount) {
        this.offset = offset;
        this.rowCount = rowCount;
    }

    @Override
    public String toSQLString() {
        return "\r\nLIMIT " + offset + ", " + rowCount;
    }
}
