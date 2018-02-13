package Business;

/*
Andrew Grosskurth
*/
import Business.AccountList;
import Business.Account;
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
public class Customer {
    
    private String custId;
    private String custPw;
    private String custFN;
    private String custLN;
    private String custAddress;
    private String custEmail;
    private Account a1;
    private AccountList accs = new AccountList();
    
    public Customer()
    {
        custId = "";
        custPw = "alwaysinvalidpasswordthatwillneverbeusedbyanyonebecausetheywouldbestupid.php.txt.jpg.html.asp//nope\\youwish";
        custFN = "";
        custLN = "";
        custAddress = "";
        custEmail = "";
    }
    
    public Customer(String id, String pw, String fn, String ln, String add, String em)
    {
        custId = id;
        custPw = pw;
        custFN = fn;
        custLN = ln;
        custAddress = add;
        custEmail = em;
    }
    
    public void setFName(String fn)
    {
        custFN = fn;
    }
    
    public String getFName()
    {
        return custFN;
    }
    
    public void setLName(String ln)
    {
        custLN = ln;
    }
    
    public String getLName()
    {
        return custLN;
    }
    
    public void setID(String id)
    {
        custId = id;
    }
    
    public String getID()
    {
        return custId;
    }
    
    public void setPW(String pw)
    {
        custPw = pw;
    }
    
    public String getPW()
    {
        return custPw;
    }
    
    public void setAddress(String add)
    {
        custAddress= add;
    }
    
    public String getAddress()
    {
        return custAddress;
    }
    
    public void setEMail(String em)
    {
        custEmail = em;
    }
    
    public String getEMail()
    {
        return custEmail;
    }
    
    public AccountList getAccountList()
    {
        return accs;
    }
    
    public void selectDB(String id)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB");
        String sql="Select * from Customers where CustID ='"+ id +"'";
        Statement stmt = con.createStatement(); 
          
        ResultSet rs = stmt.executeQuery(sql);  
        rs.next();
        
        setID(rs.getString(1));
        setPW(rs.getString(2));
        setFName(rs.getString(3));
        setLName(rs.getString(4));
        setAddress(rs.getString(5));
        setEMail(rs.getString(6));
        rs.close();
        
        getAccounts(getID());
        display();
        
        con.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
    public void insertDB(String id, String pw, String fn, String ln, String add, String em)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB");
        PreparedStatement prep = con.prepareStatement("INSERT INTO Customer(CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail) VALUES(?,?,?,?,?,?)");
        prep.setString(1, id);
        prep.setString(2, pw);
        prep.setString(3, fn);
        prep.setString(4, ln);
        prep.setString(5, add);
        prep.setString(6, em);
        prep.executeUpdate();
        con.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
    public void deleteDB(String id)
    {
        try
        {
        selectDB(id);
        String delete = custId;
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:JavaDB1");
	Statement stmt = con.createStatement();
	stmt.executeUpdate("DELETE FROM Students WHERE ID=" + delete);
        con.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    
    }
    
    public void getAccounts(String id)
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB");
            String sql="Select AcctNo from Accounts where cid ='"+ id +"'";
            Statement stmt = con.createStatement();
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
        
            while(rs.next())
            {
                String acno = rs.getString(1);
                a1 = new Account();
                a1.selectDB(acno);
                accs.addAccount(a1);
            }       
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void display()
    {
        System.out.println("First Name: " + getFName());
        System.out.println("Last Name: " + getLName());
        System.out.println("Customer ID: " + getID());
        System.out.println("Password: " + getPW());
        System.out.println("Address: " + getAddress());
        System.out.println("Email: " + getEMail());
        System.out.println("============================================");        
        accs.display();
    }

}
