import java.sql.*;
import java.lang.*;


public class Database {
    public static String JDBCDriverSQLite = "org.sqlite.jdbc";
    public static String JDBCUrlSQLite = "jdbc:sqlite:test.db";
    protected Statement statement;
    protected static Connection connection;
    public  static Connection getConnection() throws SQLException{
        if (connection == null) {
            if (JDBCDriverSQLite == null || JDBCUrlSQLite == null) {
                throw new IllegalStateException("Illegal request. Call setConnection() before.");
            }
            try {
                Class.forName(JDBCDriverSQLite);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(JDBCUrlSQLite);
        }
        return connection;
    }
    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}
