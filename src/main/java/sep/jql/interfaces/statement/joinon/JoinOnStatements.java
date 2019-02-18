package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;

public interface JoinOnStatements extends Statement {

    void add(JoinOnStatement joinOnStatement);

    JoinOnStatement getLast();

}
