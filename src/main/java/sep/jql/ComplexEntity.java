package sep.jql;

import java.util.*;
import java.util.stream.Collectors;

public class ComplexEntity<T> {

    T mainEntity;

    Map<Class<?>, List<ComplexEntity<?>>> joinMap = new HashMap<>();

    ComplexEntity(T mainEntity) {
        this.mainEntity = mainEntity;
    }

    public T getMainEntity() {
        return mainEntity;
    }

    public <R> List<R> getJoinEntities(Class<R> type) {
        Map<Class<?>, List<ComplexEntity<?>>> joinMap = this.joinMap;

        List<R> result = new ArrayList<>();
        Deque<ComplexEntity<?>> deque = new ArrayDeque<>();
        do {
            deque.poll();
            for (Class<?> key : joinMap.keySet()) {
                if (key.equals(type)) {
                    for (ComplexEntity<?> complexEntity : joinMap.get(key)) {
                        result.add((R) complexEntity.mainEntity);
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
}
