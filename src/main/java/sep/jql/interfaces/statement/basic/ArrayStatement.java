package sep.jql.interfaces.statement.basic;

public interface ArrayStatement<S extends Statement> extends Statement {

    void add(S statement);

    S getLast();

}
