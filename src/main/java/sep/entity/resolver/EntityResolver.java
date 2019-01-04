package sep.entity.resolver;

import sep.entity.struct.entity.Entity;

public interface EntityResolver {

    Entity resolve(Class entityClass);

}
