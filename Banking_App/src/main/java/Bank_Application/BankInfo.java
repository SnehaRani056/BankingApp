package Bank_Application;

import java.util.Scanner;

public class BankInfo
{
    private static String accno;
    private String name;
    private String acc_type;
    private long balance;


    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public long getBalance()
    {
        return balance;
    }
    public void setBalance(long balance)
    {
        this.balance = balance;
    }
    public static String getAccno()
    {
        return accno;
    }
    public void setAccno(String accno)
    {
        this.accno = accno;
    }
    public String getAcc_type()
    {
        return acc_type;
    }
    public void setAcc_type(String acc_type)
    {
        this.acc_type = acc_type;
    }

}

