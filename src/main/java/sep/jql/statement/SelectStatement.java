package sep.jql.statement;

import sep.jql.component.*;
import sep.jql.condition.ConditionChain;
import sep.sql.SQLConvertible;

public interface SelectStatement<M> extends Statement {

    FromStatement<M> getFromStatement();

    <A, B> JoinStatement<M, A, B> getJoinStatement(Class<A> rootClass, Class<B> joinClass);

    <A, B> OnStatement<M, A, B> getOnStatement(Class<A> rootClass, Class<B> joinClass);

    WhereStatement<M> getWhereStatement();

    OrderByStatement<M> getOrderByStatement();

    LimitStatement<M> getLimitStatement();

}
