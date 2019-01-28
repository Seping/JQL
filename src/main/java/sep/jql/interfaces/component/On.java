package sep.jql.interfaces.component;

import sep.jql.interfaces.able.Joinable;
import sep.jql.interfaces.able.Whereable;

public interface On<M, A, B> extends Whereable<M>, Joinable<M> {
}
