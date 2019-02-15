package sep.jql.interfaces.statement.select;

import sep.jql.interfaces.statement.Expression;

public interface SelectExpression extends Expression {

    <E> void addEntity(Class<E> fromClass);

}
