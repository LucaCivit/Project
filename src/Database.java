import java.sql.*;
import java.lang.*;


public class Database {
    public static String JDBCDriverSQLite = "org.sqlite.JDBC";
    public static String JDBCUrlSQLite = "jdbc:sqlite:game.db";
    protected  Statement statement;
    protected  Connection connection;

    public void start() {
        if (connection == null) {
            try {
                Class.forName(JDBCDriverSQLite);
                connection = DriverManager.getConnection(JDBCUrlSQLite);
                statement = connection.createStatement();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void test() throws SQLException {
        try {
            statement.executeUpdate("SELECT * FROM player ");
        }
        catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS player");
            statement.executeUpdate("CREATE TABLE player" + "( ID INTEGER" + "score INTEGER " + ",time DATE )");
            statement.executeUpdate("INSERT INTO player" + "VALUES (1 , 0 , 0)");
        }
    }
    //da vedere bene
    /*public void savedata(Date timedata){
        try {
            statement.executeUpdate("UPDATE player SET time = "timedata" WHERE ID = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
