package sep.entity.resolver;

import sep.entity.resolver.asm.AnnotationBasicASMResolver;
import sep.entity.struct.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class EntityRepository {

    private static EntityResolver entityResolver;
    static {
        entityResolver = new AnnotationBasicASMResolver();
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
