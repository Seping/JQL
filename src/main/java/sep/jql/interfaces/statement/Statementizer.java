package sep.jql.interfaces.statement;

import sep.jql.interfaces.component.From;
import sep.jql.interfaces.statement.query.QueryStatement;

public interface Statementizer {
    QueryStatement statementize(From<?> from);
}
