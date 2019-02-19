package sep.jql.interfaces.able;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.order.Order;

public interface OrderByable<M> extends Limitable<M> {

    Limitable<M> orderBy(Attribute<M> attribute, Order order);

}
