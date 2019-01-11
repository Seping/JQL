package sep.entity.resolver;

import sep.entity.struct.entity.Entity;

public interface EntityResolver {

    <T> Entity<T> resolve(Class<T> entityClass);

}
