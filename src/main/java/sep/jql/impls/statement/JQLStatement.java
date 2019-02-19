package sep.jql.impls.statement;

import sep.jql.impls.statement.joinon.JQLJoinOnStatements;
import sep.jql.interfaces.statement.from.FromStatement;
import sep.jql.interfaces.statement.joinon.JoinOnStatements;
import sep.jql.interfaces.statement.limit.LimitStatement;
import sep.jql.interfaces.statement.orderby.OrderByStatement;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.jql.interfaces.statement.select.SelectStatement;
import sep.jql.interfaces.statement.where.WhereStatement;

public class JQLStatement implements QueryStatement {

    private SelectStatement selectStatement;
    private FromStatement fromStatement;
    private JoinOnStatements joinOnStatements = new JQLJoinOnStatements();
    private WhereStatement whereStatement;
    private OrderByStatement orderByStatement;
    private LimitStatement limitStatement;

    @Override
    public SelectStatement getSelectStatement() {
        return selectStatement;
    }

    @Override
    public void setSelectStatement(SelectStatement selectStatement) {
        this.selectStatement = selectStatement;
    }

    @Override
    public FromStatement getFromStatement() {
        return fromStatement;
    }

    @Override
    public void setFromStatement(FromStatement fromStatement) {
        this.fromStatement = fromStatement;
    }

    @Override
    public JoinOnStatements getJoinOnStatements() {
        return joinOnStatements;
    }

    @Override
    public void setJoinOnStatements(JoinOnStatements joinOnStatements) {
        this.joinOnStatements = joinOnStatements;
    }

    @Override
    public WhereStatement getWhereStatement() {
        return whereStatement;
    }

    @Override
    public void setWhereStatement(WhereStatement whereStatement) {
        this.whereStatement = whereStatement;
    }

    @Override
    public OrderByStatement getOrderByStatement() {
        return orderByStatement;
    }

    @Override
    public void setOrderByStatement(OrderByStatement orderByStatement) {
        this.orderByStatement = orderByStatement;
    }

    @Override
    public LimitStatement getLimitStatement() {
        return limitStatement;
    }

    @Override
    public void setLimitStatement(LimitStatement limitStatement) {
        this.limitStatement = limitStatement;
    }

    @Override
    public String toSQLString() {
        return (selectStatement != null ? selectStatement.toSQLString() : "")
            + (fromStatement != null ? "\r\n" + fromStatement.toSQLString() : "")
            + (joinOnStatements != null ? "\r\n" + joinOnStatements.toSQLString() : "")
            + (whereStatement != null ? "\r\n" + whereStatement.toSQLString() : "")
            + (orderByStatement != null ? "\r\n" + orderByStatement.toSQLString() : "")
            + (limitStatement != null ? "\r\n" + limitStatement.toSQLString() : "");
    }
}
