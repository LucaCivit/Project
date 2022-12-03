import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    /*public void CalcolaGuadagno(Database db){
        String optime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String cltime = db.getTime();
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
             date1 = format.parse(optime);
             date2 = format.parse(cltime);
        } catch (ParseException p){
            p.printStackTrace();
        }
        long difference = date2.getTime() - date1.getTime();
        System.out.println(difference);

    }*/

}


