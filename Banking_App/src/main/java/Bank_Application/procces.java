package Bank_Application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import static Bank_Application.Main.con;
import static Bank_Application.Main.preparedStatement;


public class procces
{
    Scanner sc = new Scanner(System.in);
    static BankInfo bank1 = new BankInfo();
      static ArrayList<BankInfo> infoList= new ArrayList<>();

  /*  static
    {
        bank1.setAccno("854621348597");
        bank1.setName("RBL Bank");
        bank1.setAcc_type("Saving");
        bank1.setBalance(10000000);

    }*/

    public void openAccount()
    {
       // BankInfo bankInfo=new BankInfo();
        System.out.print("Enter Account No: ");
        bank1.setAccno(sc.next());
        System.out.print("Enter Account type: ");
        bank1.setAcc_type(sc.next());
        System.out.print("Enter Name: ");
        bank1.setName(sc.next());
        System.out.print("Enter Balance: ");
        bank1.setBalance(sc.nextLong());
        infoList.add(bank1);

        System.out.println("------YOUR ACCOUNT DETAILS IS -------");
        System.out.println("Name of account holder :: " + bank1.getName());
        System.out.println("Account no             :: " + bank1.getAccno());
        System.out.println("Account type           :: " + bank1.getAcc_type());
        System.out.println("Balance                :: " + bank1.getBalance());
       // insertIntoDb(bank1.getAccno(), bank1.getAcc_type(), bank1.getName(), bank1.getBalance());
        try {
            insertIntoDb(bank1.getAccno(), bank1.getAcc_type(), bank1.getName(), bank1.getBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

     static void insertIntoDb(String acno, String actype, String acc_name,long bal) throws SQLException {
        String query = "insert into account (acno,actype,acc_name,bal) VALUES (? , ?, ?, ?)";
        preparedStatement =con.prepareStatement(query);
        preparedStatement.setString(1,acno);
        preparedStatement.setString(2,actype);
        preparedStatement.setString(3,acc_name);
        preparedStatement.setLong(4,bal);

        preparedStatement.executeUpdate();
        System.out.println("Data Inserted ....");
    }


        public void demoaccount()
    {
        int  demobalance=50000;
        System.out.println("Name of account holder :: " + "Demo user");
        System.out.println("Account no             :: " + "8525123871");
        System.out.println("Account type           :: " + "demo");
        System.out.println("Balance                :: " + demobalance);

    }

   
    public void deposite()
    {
        System.out.println("Enter the Amount you want to deposit ::");
        int deposit =sc.nextInt();
        int amount =(int) ((bank1.getBalance())+deposit);
        bank1.setBalance(amount);
        System.out.println(" "+ deposit+" is deposited into your Account");
        System.out.println("Current Available Balance is Rs = "+ bank1.getBalance());

    }
    public void withdraw()
    {

        System.out.println("Enter the Amount you want to withdraw:");
        Scanner sc= new Scanner(System.in);
        int withdraw =sc.nextInt();
        if(withdraw<bank1.getBalance())
        {
            bank1.setBalance(bank1.getBalance()-withdraw);
            System.out.println(" "+ withdraw+" is withdrawn from your Account");
            System.out.println("Current Available Balance is Rs  ::"+ bank1.getBalance());
        }
        else
        {
            System.out.println("Low Balance");
            System.out.println("Current Available Balance is Rs  ::"+ bank1.getBalance());
        }
    }
    public void checkbalance()
    {
        System.out.println("Enter account no.: ");
        String acNo=sc.next();
        for(BankInfo bInfo: infoList)
        {
            if(bInfo.getAccno().equals(acNo)) {
                System.out.println("Your name is           :: " + bInfo.getName());
                System.out.println("Account no             :: " + bInfo.getAccno());
                System.out.println("Account type           :: " + bInfo.getAcc_type());
                System.out.println("Balance                :: " + bInfo.getBalance());
                //break;
            }


        }


        System.out.println("THANKS FOR BALANCE CHECKING ");

    }
    /*private static void dbConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/your_database";
            String user = "your_username";
            String password = "your_password";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established.");
             PreparedStatement preparedStatement;
             ResultSet resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }




