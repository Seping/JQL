package sep.jql.interfaces.statement;

import sep.sql.SQLConvertible;

public interface UnaryStatement<T> extends Statement {

    T getOperand();

    void setOperand(T t);

}
