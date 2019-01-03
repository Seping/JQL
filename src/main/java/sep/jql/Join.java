package sep.jql;

import sep.entity.resolver.EntityRepository;

public class Join<M, T, R> {

    JQL<M> jql;

    Class<T> rootClass;
    Class<R> joinClass;
    On<M, T, R> on;

    public Join(JQL<M> jql, Class<T> rootClass, Class<R> joinClass) {
        this.jql = jql;
        this.rootClass = rootClass;
        this.joinClass = joinClass;

        jql.joins.add(this);
    }

    public On<M, T, R> on(OnSpecification<T, R> onSpecification) {
        On<M, T, R> on = new On<>(jql, joinClass, onSpecification);
        this.on = on;
        return on;
    }

    @Override
    public String toString() {
        return "\tLEFT JOIN " + EntityRepository.getByClass(joinClass).getTableNameWithQuote() + "\r\n" +
                on.toString();
    }
}
