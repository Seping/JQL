package sep.entity.resolver;

import sep.entity.resolver.asm.hibernate.HibernateASMResolver;
import sep.entity.struct.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRepository {

    private static HibernateASMResolver hibernateASMResolver = new HibernateASMResolver();

    private static Map<String, Entity<?>> map = new HashMap<>();

    public static Entity getByClass(Class clazz) {
        return map.computeIfAbsent(clazz.getName(), key -> hibernateASMResolver.resolve(clazz));
    }

    public static Entity getByClassName(String fullClassName) {
        return map.computeIfAbsent(fullClassName, key -> {
            try {
                return hibernateASMResolver.resolve(Class.forName(key));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
