package sep.jql.interfaces.statement;

public interface CollectionStatement<S extends Statement> extends Statement {

    void add(S statement);

    S getLast();

}
