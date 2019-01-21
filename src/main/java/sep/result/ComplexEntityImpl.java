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

    @Override
    public List<ComplexEntity<?>> getJoinEntities(Class<?> type) {
        List<?> result = new ArrayList<>();

        Deque<ComplexEntity<?>> deque = new ArrayDeque<>();
        deque.add(this);
        do {
            ComplexEntity<?> complexEntity = deque.poll();
            for (Class<?> key : complexEntity.getJoinTypes()) {
                List<ComplexEntity<?>> joinEntities = complexEntity.getJoinEntities(key);
                if (key.equals(type)) {
                    for (ComplexEntity<?> complexEntity : joinMap.get(key)) {
                        result.add((R) complexEntity.getMainEntity());
                    }
                    break;
                } else {
                    deque.addAll(joinMap.get(key));
                }
            }
            if (deque.size() > 0) {
                joinMap = deque.getFirst().joinMap;
            }
        } while (deque.size() > 0);
        return result;
    }

    @Override
    public Set<Class<?>> getJoinTypes() {
        return joinMap.keySet();
    }
}
