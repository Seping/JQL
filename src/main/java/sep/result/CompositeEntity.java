package sep.result;

import java.util.List;
import java.util.Set;

public interface CompositeEntity<T> {

    T getMainEntity();

    <R> List<R> getJoinEntities(Class<R> type);

    Set<Class<?>> getJoinTypes();

}
