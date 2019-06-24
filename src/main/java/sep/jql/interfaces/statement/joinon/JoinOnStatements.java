package sep.jql.interfaces.statement.joinon;

import sep.jql.interfaces.statement.Statement;

import java.util.List;

public interface JoinOnStatements extends Statement {

    List<JoinOnStatement> getJoinOnStatementList();

    void add(JoinOnStatement joinOnStatement);

    JoinOnStatement getLast();

}
