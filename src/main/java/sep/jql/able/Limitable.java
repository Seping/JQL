package sep.jql.able;

import sep.sql.SQLConvertible;

public interface Limitable<T> extends SQLConvertible {

    Limit<T> limit(Integer offset, Integer rowCount);

}
