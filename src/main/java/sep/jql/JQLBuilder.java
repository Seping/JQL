package sep.jql;

public interface JQLBuilder<T> {

    JQLStatement<T> build(JQL<T> jql);

}
