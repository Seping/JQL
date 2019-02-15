package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Expression;

public interface JoinExpression extends Expression {
    <E> void setEntity(Class<E> joinClass);
}
