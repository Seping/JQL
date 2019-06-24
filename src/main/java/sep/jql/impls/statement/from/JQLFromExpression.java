package sep.jql.impls.statement.from;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.jql.interfaces.statement.from.FromExpression;

public class JQLFromExpression implements FromExpression {

    private Entity entity;

    @Override
    public <E> Entity<E> getEntity() {
        return entity;
    }

    @Override
    public <E> void setEntity(Class<E> entityClass) {
        entity = EntityRepository.getEntity(entityClass);
    }

    @Override
    public String toSQLString() {
        return entity.toSQLString();
    }
}
