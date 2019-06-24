package sep.jql.interfaces.statement.joinon;

import sep.entity.struct.entity.Entity;
import sep.jql.interfaces.statement.Expression;

public interface JoinExpression extends Expression {

    <E> Entity<E> getEntity();

    <E> void setEntity(Class<E> joinClass);
}
