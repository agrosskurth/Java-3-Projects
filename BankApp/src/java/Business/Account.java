package Business;

/*
Andrew Grosskurth
*/
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Account {
    
    private String acctNo;
    private String cId;
    private String acctType;
    private Double balance;
    
    public Account()
    {
        acctNo = "";
        cId = "";
        acctType = "";
        balance = 0.0;
    }
    
    public Account(String ano, String cid, String actype, Double bal)
    {
        acctNo = ano;
        cId = cid;
        acctType = actype;
        balance = bal;
    }
    
    public void setAcctNo(String ano)
    {
        acctNo = ano;
    }
    
    public String getAcctNo()
    {
        return acctNo;
    }
        
    public void setCId(String cid)
    {
        cId = cid;
    }
    
    public String getCId()
    {
        return cId;
    }
     
    public void setAcctType(String actype)
    {
        acctType = actype;
    }
    
    public String getAcctType()
    {
        return acctType;
    }
    
    public void setBalance(Double bal)
    {
        balance = bal;
    }
    
    public Double getBalance()
    {
        return balance;
    }
    
    public void selectDB(String ano)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB");
        String sql="Select * from Accounts where AcctNo ='"+ ano +"'";
        Statement stmt = con.createStatement();
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        
        setAcctNo(rs.getString(1));
        setCId(rs.getString(2));
        setAcctType(rs.getString(3));
        setBalance(rs.getDouble(4));
        con.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
    public void updateDB()
    {
        
    }
    
    public void deposit(Double dep)
    {
        balance = balance + dep;
        updateDB();
    }
    
    public void withdraw(Double wit)
    {
        balance = balance - wit;
        updateDB();
    }
    
    public void display()
    {
        System.out.println("Account ID: " + getAcctNo());
        System.out.println("Customer ID: " + getCId());
        System.out.println("Account Type: " + getAcctType());
        System.out.println("Balance: " + getBalance());
        System.out.println("============================================");
    }
    
    public static void main(String args[])
    {
        Account a1;
        a1 = new Account();
        a1.selectDB("90002");
        a1.display();
    }
}
