package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java_DB {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "HICHAM";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    private static final String URL = String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME);

    private static Connection con ;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con ;
    }


}
