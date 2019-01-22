package sep.result;

import java.util.*;

public class ComplexEntityImpl<T> implements ComplexEntity<T> {

    private T mainEntity;

    private Map<Class<?>, List<ComplexEntity<?>>> joinMap = new HashMap<>();

    public ComplexEntityImpl(T mainEntity) {
        this.mainEntity = mainEntity;
    }

    @Override
    public T getMainEntity() {
        return mainEntity;
    }

    public <R> List<R> getJoinEntities(Class<R> type) {
        List<?> result = new ArrayList<>();



        return result;
    }

    @Override
    public Set<Class<?>> getJoinTypes() {
        return joinMap.keySet();
    }
}
