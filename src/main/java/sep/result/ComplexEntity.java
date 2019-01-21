package sep.result;

import java.util.List;
import java.util.Set;

public interface ComplexEntity<T> {

    T getMainEntity();

    List<?> getJoinEntities(Class<?> type);

    List<ComplexEntity<?>> getJoinComplexEntities(Class<?> type);

    Set<Class<?>> getJoinTypes();

}
