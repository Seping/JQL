package sep.jql;

public class On<M, T, R> {

    JQL<M> jql;

    Class<R> joinClass;

    OnSpecification<T, R> onSpecification;
    Root<T> root1 = new Root<>();
    Root<R> root2 = new Root<>();
    ConditionBuilder conditionBuilder = new ConditionBuilder();

    public On(JQL<M> jql, Class<R> joinClass, OnSpecification<T, R> onSpecification) {
        this.jql = jql;
        this.joinClass = joinClass;
        this.onSpecification = onSpecification;

        onSpecification.specific(root1, root2, conditionBuilder);
    }

    @Override
    public String toString() {
        return "\tON " + conditionBuilder.toString();
    }

    public <A, B> Join<M, A, B> join(Class<A> rootClass, Class<B> joinClass) {
        Join<M, A, B> join = new Join<>(jql, rootClass, joinClass);
        return join;
    }

    public Where<M> where(WhereSpecification<M> whereSpecification) {
        Where<M> where = new Where(jql, whereSpecification);
        return where;
    }

    public OrderBy<T> orderBy(Attribute<T> attribute) {
        OrderBy<T> orderBy = new OrderBy<>(jql, attribute);
        return orderBy;
    }

    public void limit(Integer offset, Integer rowCount) {
        Limit limit = new Limit(jql, offset, rowCount);
    }

}
