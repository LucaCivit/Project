import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
    new Database();
        try {
            Database.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
