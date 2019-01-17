package sep.jql;

import sep.sql.SQLConvertible;

public abstract class SQLConvertibleChain {

    SQLConvertible next;

    protected <T extends SQLConvertible> T setNextAndReturn(T sqlConvertible) {
        next = sqlConvertible;
        return (T) next;
    }

}
