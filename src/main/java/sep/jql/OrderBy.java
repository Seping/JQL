package sep.jql;

import sep.util.SQLStringUtil;

public class OrderBy<T> {

    JQL jql;

    Attribute<T> attribute;

    OrderBy(JQL jql, Attribute<T> attribute) {
        this.jql = jql;
        this.attribute = attribute;

        jql.orderBy = this;
    }

    @Override
    public String toString() {
        return "Order By " + SQLStringUtil.attribute2String(attribute);
    }

    public Limit limit(Integer offset, Integer rowCount) {
        Limit limit = new Limit(jql, offset, rowCount);
        return limit;
    }

    public JQLStatement<T> end() {
        return new JQLStatement<>(jql);
    }
}
