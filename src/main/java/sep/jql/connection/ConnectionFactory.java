package sep.jql.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory singleInstance = new ConnectionFactory();
    private ConnectionFactory() {}

    private ConnectionAcquirer connectionAcquirer;

    public static void setConnectionAcquirer(ConnectionAcquirer connectionAcquirer) {
        singleInstance.connectionAcquirer = connectionAcquirer;
    }

    public static Connection getConnection() {
        return singleInstance.connectionAcquirer.getConnection();
    }



}
