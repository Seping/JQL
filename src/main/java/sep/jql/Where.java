package sep.jql;

public class Where<T> {

    JQL<T> jql;

    WhereSpecification<T> whereSpecification;
    Root<T> root = new Root<>();
    ConditionBuilder conditionBuilder = new ConditionBuilder();


    Where(JQL<T> jql, WhereSpecification<T> whereSpecification) {
        this.jql = jql;
        this.whereSpecification = whereSpecification;

        jql.where = this;
        whereSpecification.specific(root, conditionBuilder);
    }

    @Override
    public String toString() {
        return "Where " + conditionBuilder.toString();
    }

    public OrderBy<T> orderBy(Attribute<T> attribution) {
        OrderBy<T> orderBy = new OrderBy<>(jql, attribution);
        return orderBy;
    }

    public void limit(Integer offset, Integer rowCount) {
        Limit limit = new Limit(jql, offset, rowCount);
    }
}
