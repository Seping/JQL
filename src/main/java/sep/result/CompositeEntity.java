package sep.result;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CompositeEntity<T> {

    T getMainEntity();

    <R> List<R> getJoinEntities(Class<R> type);

    Set<Class<?>> getJoinTypes();

    Map<Class<?>, List<CompositeEntity<?>>> getJoinMap();

}
