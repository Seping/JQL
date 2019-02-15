package sep.jql.interfaces.statement.query;

import sep.jql.interfaces.statement.Statement;
import sep.jql.interfaces.statement.from.FromStatement;
import sep.jql.interfaces.statement.joinon.JoinOnStatements;
import sep.jql.interfaces.statement.limit.LimitStatement;
import sep.jql.interfaces.statement.orderby.OrderByStatement;
import sep.jql.interfaces.statement.select.SelectStatement;
import sep.jql.interfaces.statement.where.WhereStatement;

public interface QueryStatement extends Statement {

    SelectStatement getSelectStatement();

    void setSelectStatement(SelectStatement selectStatement);

    FromStatement getFromStatement();

    void setFromStatement(FromStatement fromStatement);

    JoinOnStatements getJoinOnStatements();

    void setJoinOnStatements(JoinOnStatements joinOnStatements);

    WhereStatement getWhereStatement();

    void setWhereStatement(WhereStatement whereStatement);

    OrderByStatement getOrderByStatement();

    void setOrderByStatement(OrderByStatement orderByStatement);

    LimitStatement getLimitStatement();

    void setLimitStatement(LimitStatement limitStatement);

}
