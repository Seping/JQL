package sep.jql.impls.statement.joinon;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.jql.interfaces.statement.joinon.JoinExpression;

public class JQLJoinExpression implements JoinExpression {

    private Entity entity;

    @Override
    public <E> void setEntity(Class<E> joinClass) {
        entity = EntityRepository.getEntity(joinClass);
    }

    @Override
    public String toSQLString() {
        return entity.toSQLString();
    }
}
