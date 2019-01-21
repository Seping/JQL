package sep.jql;

import sep.jql.JQL;

import java.util.*;

public class EntityJoinUnion {

    List<Class<?>> entityTypes = new ArrayList<>();

    List<Integer> indexes = new ArrayList<>();

    EntityJoinUnion(JQL<?> jql) {
        entityTypes.add(jql.mainClass);
        indexes.add(0);

        for (SQLConvertibleChain chain = jql;
             chain instanceof JQLJoin && chain != null;
             chain = chain.next) {
            Class<?> rootClass = ((JQLJoin) chain).rootClass;
            Class<?> joinClass = ((JQLJoin) chain).joinClass;
            if (entityTypes.contains(rootClass)) {
                entityTypes.add(joinClass);
                indexes.add(entityTypes.indexOf(rootClass));
            } else if (entityTypes.contains(joinClass)) {
                entityTypes.add(rootClass);
                indexes.add(entityTypes.indexOf(joinClass));
            }
        }
    }

    public List<Class<?>> getJoinTrace(Class<?> endpoint) {
        List<Class<?>> trace = new ArrayList<>();

        Class<?> type = endpoint;
        Integer index = indexes.get(entityTypes.indexOf(type));
        do {
            trace.add(type);

            type = entityTypes.get(index);
            index = indexes.get(entityTypes.indexOf(type));
        } while (!index.equals(entityTypes.indexOf(type)));

        Collections.reverse(trace);
        return trace;
    }

}
