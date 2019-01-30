package sep.jql.interfaces.statement;

public interface QueryStatement extends CollectionStatement<Statement> {

    void setSelectStatement(SelectStatement selectStatement);

    SelectStatement getSelectStatement();

}
