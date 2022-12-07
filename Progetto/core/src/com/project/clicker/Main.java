package com.project.clicker;

import java.sql.*;


public class Main {
    public static void main(String[] args)  {

        Database db = new Database();
        db.start();
        try{
            db.test();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        db.save(1000);

        db.close();
    }



}


