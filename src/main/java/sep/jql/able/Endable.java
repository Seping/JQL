package sep.jql.able;

import sep.jql.JQLStatement;

public interface Endable<T> {

    JQLStatement<T> end();

}
