package sep.jql;

import sep.sql.SQLConvertible;

public abstract class SQLConvertibleChain implements SQLConvertible {

    SQLConvertibleChain next;

    protected <T extends SQLConvertibleChain> T setNextAndReturn(T sqlConvertibleChain) {
        next = sqlConvertibleChain;
        return (T) next;
    }

    public String toSQLStringChain() {
        return next == null ? this.toSQLString() : this.toSQLString() + this.next.toSQLString();
    }

}
