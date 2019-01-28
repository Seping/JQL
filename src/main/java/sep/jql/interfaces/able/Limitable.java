package sep.jql.interfaces.able;

import sep.jql.interfaces.component.Limit;

public interface Limitable<T> {

    Limit<T> limit(Integer offset, Integer rowCount);

}
