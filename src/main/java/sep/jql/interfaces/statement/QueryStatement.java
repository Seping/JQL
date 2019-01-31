package sep.jql.interfaces.statement;

public interface QueryStatement extends CollectionStatement<Statement> {

    void setSelectStatement(SelectStatement selectStatement);

    void setFromStatement(FromStatement fromStatement);

    SelectStatement getSelectStatement();

    JoinOnCollectionStatement getJoinOnCollectionStatement();

}
