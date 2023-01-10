package com.project.clicker;

import java.sql.*;
import java.lang.*;
import java.text.SimpleDateFormat;



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
           System.out.println("unlocked = " + rs.getString("unlocked"));
           System.out.println("nemico = "+ rs.getString("nemico"));
           System.out.println("vita = "+ rs.getString("vita"));
           System.out.println("time = " + rs.getString("time"));
        }
        catch (SQLException e) {
            st.executeUpdate("DROP TABLE IF EXISTS player");
            st.executeUpdate("CREATE TABLE player ( ID INTEGER,score INTEGER,unlocked INTEGER,nemico INTEGER,vita INTEGER,time TEXT,PRIMARY KEY (ID))");
            upst = connection.prepareStatement("INSERT INTO player VALUES (1 , 0 , 1 ,0,1000, 0)");
            upst.executeUpdate();
        }
    }

    public void save(int Score,int unlocked,int nem,int vit){
        try {
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
            upst = connection.prepareStatement("UPDATE player SET score=?,unlocked=?,nemico=?,vita=?,time=? WHERE ID = 1");
            upst.setInt(1,Score);
            upst.setInt(2,unlocked);
            upst.setInt(3,nem);
            upst.setInt(4,vit);
            upst.setString(5,timeStamp);
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

    public int getUnlocked(){
        int unlckd = 0;
        try {
            rs = st.executeQuery("SELECT * FROM player ");
            unlckd = rs.getInt("unlocked");

        } catch (SQLException e){
            e.printStackTrace();
        }
        return unlckd;
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
    public int getEnemy(){
        int en = 0;

        try {
            rs = st.executeQuery("SELECT * FROM player");
            en = rs.getInt("nemico");
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return en;
    }
    public int getLife(){
        int li = 0;

        try {
            rs = st.executeQuery("SELECT * FROM player");
            li = rs.getInt("vita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
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
