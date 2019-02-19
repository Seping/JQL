package sep.jql.impls.statement.orderby;

import sep.entity.struct.field.attribute.Attribute;
import sep.jql.interfaces.order.Order;
import sep.jql.interfaces.statement.orderby.OrderByExpression;

public class JQLOrderByExpression implements OrderByExpression {

    private Attribute attribute;
    private Order order;

    public <M> JQLOrderByExpression(Attribute<M> attribute, Order order) {
        this.attribute = attribute;
        this.order = order;
    }

    @Override
    public String toSQLString() {
        return attribute.toSQLString() + " " + order.toSQLString();
    }
}
