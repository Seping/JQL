package sep.jql.interfaces.statement;

import sep.jql.interfaces.statement.basic.ArrayStatement;
import sep.jql.interfaces.statement.basic.Statement;

public interface QueryStatement extends ArrayStatement<Statement> {

    void setSelectStatement(SelectStatement selectStatement);

    void setFromStatement(FromStatement fromStatement);

    SelectStatement getSelectStatement();

    JoinOnArrayStatement getJoinOnCollectionStatement();

}
