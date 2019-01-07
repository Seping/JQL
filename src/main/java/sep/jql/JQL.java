package sep.jql;

import java.util.ArrayList;
import java.util.List;

public class JQL<T> {

    Class<T> mainClass;
    List<Join> joins = new ArrayList<>();
    Where<T> where;
    OrderBy<T> orderBy;
    Limit limit;

    private JQL(Class<T> mainClass) { this.mainClass = mainClass; }

    public static <T> JQL<T> from(Class<T> fromClass) {
        return new JQL<>(fromClass);
    }

    public <R> Join<T, T, R> join(Class<R> joinClass) {
        Join<T, T, R> join = new Join<>(this, mainClass, joinClass);
        return join;
    }

    public Where<T> where(WhereSpecification<T> whereSpecification) {
        Where<T> where = new Where(this, whereSpecification);
        return where;
    }

    public OrderBy<T> orderBy(Attribute<T> attribute) {
        OrderBy<T> orderBy = new OrderBy<>(this, attribute);
        return orderBy;
    }

    public void limit(Integer offset, Integer rowCount) {
        Limit limit = new Limit(this, offset, rowCount);
    }

    public JQLStatement<T> end() {
        return new JQLStatement<>(this);
    }
}
