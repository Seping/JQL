package sep.jql.interfaces.component;

import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.able.SingleJoinable;
import sep.jql.interfaces.able.Whereable;

public interface From<M> extends SingleJoinable<M>, Whereable<M>, OrderByable<M> {
}
