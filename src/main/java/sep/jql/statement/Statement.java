package sep.jql.statement;

import sep.jql.component.*;
import sep.jql.condition.ConditionChain;
import sep.sql.SQLConvertible;

public interface Statement<M> extends SQLConvertible {

    From<M> getFrom();

    <A, B> Join<M, A, B> getJoin(Class<A> rootClass, Class<B> joinClass);

    <A, B> On<M, A, B> getOn(Class<A> rootClass, Class<B> joinClass);

    ConditionChain getOnConditionChain(On<M, ?, ?> on);

    Where<M> getWhere();

    ConditionChain getWhereConditionChain(Where<M> where);

    OrderBy<M> getOrderBy();

    Limit<M> getLimit();

}
