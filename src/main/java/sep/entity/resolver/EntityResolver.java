package sep.entity.resolver;

import sep.entity.struct.Entity;

public abstract class EntityResolver {

    public abstract Entity doResolve(Class entityClass);

    public final Entity resolve(Class entityClass) {
        Entity entity = doResolve(entityClass);
        return entity;
    }

}
