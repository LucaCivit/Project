import java.sql.*;
import java.util.Calendar;

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
        Calendar calendar = Calendar.getInstance();
        Date playertime = (Date) calendar.getTime();

        db.close();






    }
}
