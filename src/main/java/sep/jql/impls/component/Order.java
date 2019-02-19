package sep.jql.impls.component;

public enum Order implements sep.jql.interfaces.order.Order {
    ASC("ASC"),
    DESC("DESC");

    private String order;
    Order(String order) {
        this.order = order;
    }

    @Override
    public String toSQLString() {
        return order;
    }
}
