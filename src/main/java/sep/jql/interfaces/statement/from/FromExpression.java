package sep.jql.interfaces.statement.from;

import sep.jql.interfaces.statement.Expression;

public interface FromExpression extends Expression {

    <E> void setEntity(Class<E> entityClass);

}
