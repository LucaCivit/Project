package com.project.clicker;

import java.sql.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.time.*;



public class Database {
    public static String JDBCDriverSQLite = "org.sqlite.JDBC";
    public static String JDBCUrlSQLite = "jdbc:sqlite:game.db";
    protected  Statement st;
    protected  PreparedStatement upst;
    protected  Connection connection;
    protected ResultSet rs;

    public void start() {
        if (connection == null) {
            try {
                Class.forName(JDBCDriverSQLite);
                connection = DriverManager.getConnection(JDBCUrlSQLite);
                st = connection.createStatement();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void test() throws SQLException {
        try {
           rs = st.executeQuery("SELECT * FROM player ");
           System.out.println("ID = "+ rs.getString("ID"));
           System.out.println("score = " + rs.getString("score"));
           System.out.println("time = " + rs.getString("time"));
        }
        catch (SQLException e) {
            st.executeUpdate("DROP TABLE IF EXISTS player");
            st.executeUpdate("CREATE TABLE player ( ID INTEGER,score INTEGER,time TEXT,PRIMARY KEY (ID))");
            upst = connection.prepareStatement("INSERT INTO player VALUES (1 , 0 , 0)");
            upst.executeUpdate();
        }
    }

    public void save(int Score){
        try {
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
            upst = connection.prepareStatement("UPDATE player SET score=?, time=? WHERE ID = 1");
            upst.setInt(1,Score);
            upst.setString(2,timeStamp);
            upst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public int getScore(){
        int score = 0;
        try {
            rs = st.executeQuery("SELECT * FROM player ");
            score = rs.getInt("score");

        } catch (SQLException e){
            e.printStackTrace();
        }
        return score;
    }

    public String getTime(){
        String time = new String();
        try {
            rs = st.executeQuery("SELECT * FROM player ");
            time = rs.getString("time");

        } catch (SQLException e){
           e.printStackTrace();
        }
        return time;
    }


    public void close() {
        if (connection != null) {
            try {
                st.close();
                upst.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
