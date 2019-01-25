package sep.jql.able;

import sep.jql.component.Limit;
import sep.sql.SQLConvertible;

public interface Limitable<T> {

    Limit<T> limit(Integer offset, Integer rowCount);

}
