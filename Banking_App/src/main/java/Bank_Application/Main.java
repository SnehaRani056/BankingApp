package Bank_Application;
import java.sql.*;
import java.util.Scanner;



public class Main
{
    static String url="jdbc:mysql://localhost:3306/mydb";
    static String username="root";
    static String password="root";
    static Connection con;

    public static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    public static void main(String[] args)
    {
        try {
            con= DriverManager.getConnection(url, username, password);

            Operation operlation = new Operation();
            operlation.bankinfo();
           }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
