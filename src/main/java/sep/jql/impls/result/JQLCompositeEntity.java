package sep.jql.impls.result;

import sep.result.CompositeEntity;

import java.util.*;

public class JQLCompositeEntity<T> implements CompositeEntity<T> {

    private T mainEntity;
    private Map<Class<?>, List<CompositeEntity<?>>> joinMap;

    public JQLCompositeEntity(T mainEntity) {
        this.mainEntity = mainEntity;
        this.joinMap = new HashMap<>();
    }

    @Override
    public T getMainEntity() {
        return mainEntity;
    }

    @Override
    public <R> List<R> getJoinEntities(Class<R> type) {
        Map<Class<?>, List<CompositeEntity<?>>> joinMap = this.joinMap;

        List<R> result = new ArrayList<>();
        Deque<CompositeEntity<?>> deque = new ArrayDeque<>();
        do {
            deque.poll();
            for (Class<?> key : joinMap.keySet()) {
                if (key.equals(type)) {
                    for (CompositeEntity<?> complexEntity : joinMap.get(key)) {
                        result.add((R) complexEntity.getMainEntity());
                    }
                    break;
                } else {
                    deque.addAll(joinMap.get(key));
                }
            }
            if (deque.size() > 0) {
                joinMap = deque.getFirst().getJoinMap();
            }
        } while (deque.size() > 0);
        return result;
    }

    @Override
    public Set<Class<?>> getJoinTypes() {
        return null;
    }

    @Override
    public Map<Class<?>, List<CompositeEntity<?>>> getJoinMap() {
        return joinMap;
    }
}
