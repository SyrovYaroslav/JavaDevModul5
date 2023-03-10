import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANSE = new Database();

    private Connection connection;

    private Database() {
        try {
            String connectionUrl = "jdbc:h2:./MegaSoft";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstanse() {
        return INSTANSE;
    }


    public Connection getConnection() {
        try {
            if (connection.isClosed()) {
                String connectionUrl = "jdbc:h2:./MegaSoft";
                connection = DriverManager.getConnection(connectionUrl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
