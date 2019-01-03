package sep.jql;

public class Limit {

    JQL jql;

    Integer offset;
    Integer rowCount;

    Limit(JQL jql, Integer offset, Integer rowCount) {
        this.jql = jql;
        this.offset = offset;
        this.rowCount = rowCount;

        jql.limit = this;
    }

    public <T> JQLStatement<T> end() {
        return new JQLStatement<T>(jql);
    }

    @Override
    public String toString() {
        return "Limit " + offset + ", " + rowCount;
    }
}
