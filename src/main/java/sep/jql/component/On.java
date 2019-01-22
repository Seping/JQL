package sep.jql.component;

import sep.jql.able.Joinable;
import sep.jql.able.Whereable;

public interface On<M, A, B> extends Whereable<M>, Joinable<M> {
}
