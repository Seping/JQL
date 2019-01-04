package sep.jql.connection;

import java.sql.Connection;

public interface ConnectionAcquirer {

    Connection getConnection();

}
