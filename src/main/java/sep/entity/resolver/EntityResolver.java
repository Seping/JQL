package sep.entity.resolver;

import sep.entity.struct.Entity;

public interface EntityResolver {

    Entity resolve(Class entityClass);

}
