package sep.entity.resolver;

import sep.entity.resolver.asm.hibernate.HibernateASMResolver;
import sep.entity.struct.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRepository {

    private static EntityResolver entityResolver;
    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            classLoader.loadClass("javax.persistence.Table");
            entityResolver = new HibernateASMResolver();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            entityResolver = null;
        }
    }

    private static Map<String, Entity<?>> map = new HashMap<>();

    public static Entity getByClass(Class clazz) {
        return map.computeIfAbsent(clazz.getName(), key -> entityResolver.resolve(clazz));
    }

    public static Entity getByClassName(String fullClassName) {
        return map.computeIfAbsent(fullClassName, key -> {
            try {
                return entityResolver.resolve(Class.forName(key));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
