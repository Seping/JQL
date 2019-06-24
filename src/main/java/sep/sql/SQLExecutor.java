package sep.sql;

import sep.jql.interfaces.statement.query.QueryStatement;
import sep.result.CompositeEntity;

import java.util.List;

public interface SQLExecutor {

    <T> List<CompositeEntity<T>> executeQuery(QueryStatement queryStatement);

}
