package sep.jql.able;

import sep.jql.statement.Statement;

public interface Endable<T> {

    Statement<T> end();

}
