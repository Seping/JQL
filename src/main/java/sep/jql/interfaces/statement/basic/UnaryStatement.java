package sep.jql.interfaces.statement.basic;

public interface UnaryStatement<T> extends Statement {

    T getOperand();

    void setOperand(T t);

}
