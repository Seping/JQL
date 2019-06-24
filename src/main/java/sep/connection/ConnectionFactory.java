package sep.connection;

import java.sql.Connection;

public class ConnectionFactory {

    private static ConnectionFactory singleInstance = new ConnectionFactory();
    private ConnectionFactory() {}

    private ConnectionAcquirer connectionAcquirer;

    public static ConnectionFactory getInstance() {
        return singleInstance;
    }

    public void setConnectionAcquirer(ConnectionAcquirer connectionAcquirer) {
        singleInstance.connectionAcquirer = connectionAcquirer;
    }

    public static Connection getConnection() {
        return singleInstance.connectionAcquirer.getConnection();
    }

}
