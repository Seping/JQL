package sep.jql.interfaces.statement.from;

import sep.entity.struct.entity.Entity;
import sep.jql.interfaces.statement.Expression;

public interface FromExpression extends Expression {

    <E> Entity<E> getEntity();

    <E> void setEntity(Class<E> entityClass);

}
