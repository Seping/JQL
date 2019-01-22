package sep.jql.component;

import sep.jql.able.SingleJoinable;
import sep.jql.able.Whereable;

public interface From<M> extends SingleJoinable<M>, Whereable<M> {
}
