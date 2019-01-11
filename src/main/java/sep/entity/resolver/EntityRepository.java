package sep.entity.resolver;

import sep.entity.resolver.asm.AnnotationBasicASMResolver;
import sep.entity.struct.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public final class EntityRepository {

    private EntityRepository() {}

    private static EntityRepository singleInstance;

    private EntityResolver entityResolver;
    private Map<Class<?>, Entity<?>> repository = new HashMap<>();

    public static Entity<?> getEntity(Class<?> entityType) {
        Entity<?> entity = getInstance().repository
                .computeIfAbsent(entityType, key -> singleInstance.entityResolver.resolve(key));
        return entity;
    }

    private static EntityRepository getInstance() {
        if (singleInstance == null) {
            singleInstance = new EntityRepository();
        }
        if (singleInstance.entityResolver == null) {
            singleInstance.entityResolver = new AnnotationBasicASMResolver();
        }
        return singleInstance;
    }

    public static void setEntityResolver(EntityResolver entityResolver) {
        singleInstance.entityResolver = entityResolver;
    }

}
