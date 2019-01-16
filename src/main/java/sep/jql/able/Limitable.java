package sep.jql.able;

import sep.sql.SQLConvertible;

public interface Limitable<T> extends Endable<T>, SQLConvertible {

    Limit<T> limit(Integer offset, Integer rowCount);

}
