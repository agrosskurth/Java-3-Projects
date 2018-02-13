/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Andrew
 */
public class Doctor 
{
    // <editor-fold defaultstate="collapsed" desc="Properties">
    private String id;
    private String passwd;
    private String firstName;
    private String lastName;
    private String email;
    private String office;
    private Appointment a1;
    private AppointmentList apps = new AppointmentList(); // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    /**
     * This is the standard blank constructor
     */
    public Doctor()
    {
        id = "";
        passwd = "";
        firstName = "";
        lastName = "";
        email = "";
        office = "";
    }
    
    /**
     * This is the standard all properties constructor
     */
    public Doctor(String did, String dpw, String dfn, String dln, String dem, String dof)
    {
        id = did;
        passwd = dpw;
        firstName = dfn;
        lastName = dln;
        email = dem;
        office = dof;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Set/Get Methods">

    /**
     *
     * This sets id to a given string
     */
    public void setID(String did)
    {
        id = did;
    }

    /**
     *
     * This returns the ID property
     */
    public String getID()
    {
        return id;
    }

    /**
     *
     * This sets password to a given string
     */
    public void setPasswd(String dpw)
    {
        passwd = dpw;
    }

    /**
     *
     * This returns the password proprtyu
     */
    public String getPasswd()
    {
        return passwd;
    }

    /**
     *
     * This sets FirstName to a given string
     */
    public void setFirstName(String dfn)
    {
        firstName = dfn;
    }

    /**
     *
     * This returns the firstName property
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     *
     * This sets LastName to a given string
     */
    public void setLastName(String dln)
    {
        lastName = dln;
    }

    /**
     *
     * This returns the lastName property
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     *
     * This sets email to a given string
     */
    public void setEmail(String dem)
    {
        email = dem;
    }

    /**
     *
     * This returns the email property
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * This sets the office to a given string
     */
    public void setOffice(String dof)
    {
        office = dof;
    }

    /**
     *
     * This returns the office property
     */
    public String getOffice()
    {
        return office;
    }

    /**
     *
     * This returns the appointment list property
     */
    public AppointmentList getAppointmentList()
    {
        return apps;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Databse Connection Methods">

    /**
     *
     * This is the method that pulls all of the information from the database 
     * and puts it into the properties for the class.
     */
    public void selectDB(String did)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql = "Select * from Dentists where id='" + did + "'";
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        
        setID(rs.getString(1));
        setPasswd(rs.getString(2));
        setFirstName(rs.getString(3));
        setLastName(rs.getString(4));
        setEmail(rs.getString(5));
        setOffice(rs.getString(6));
        
        getAppointments(did);
        
        con.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    /**
     *
     * This method will take some parameters and use them to update the Dentist table in the database 
     * with the given information.
     */
    public void updateDB(String did, String dwd, String dfn, String dln, String dem, String dof)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE Dentists SET passwd = ?, firstName = ?, lastName = ?, email = ?, office = ? WHERE id = ?");
        ps.setString(1, dwd);
        ps.setString(2, dfn);
        ps.setString(3, dln);
        ps.setString(4, dem);
        ps.setString(5, dof);
        ps.setString(6, did);
        
        ps.executeUpdate();
        ps.close();
        con.close();
        selectDB(did);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     *
     * This will delete any entry in the Dentist table in the database with the given dentist id
     */
    public void deleteDB(String did)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql = "DELETE FROM Dentists WHERE idd = '" + did + "'";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        con.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    /**
     *
     * This creates an AppointmentList that holds all of the appointments for a given doctor 
     * and adds it to the AppointmentList property.
     */
    public void getAppointments(String id)
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
            String sql="Select patId from Appointments where dentId ='"+ id +"'";
            Statement stmt = con.createStatement();
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
        
            while(rs.next())
            {
                int i = 0;
                String did = rs.getString(1);
                a1 = new Appointment();
                a1.selectDB(did);
                apps.addAppointment(a1);
                apps.display();
            }       
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main/Display Methods">

    /**
     * This is a standard display method for debugging
     */
    public void display()
    {
        System.out.println("DentId: " + getID());
        System.out.println("Passwd: " + getPasswd());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Email: " + getEmail());
        System.out.println("Office: " + getOffice());
    }
    
    /**
     *
     * This is a standard main method for debugging
     */
    public static void main(String args[])
    {
        Doctor d1 = new Doctor();
        d1.selectDB("D201");
        d1.updateDB("D201", "1111", "Frankie", "Martins", "fmm@gmail.com", "541");
        d1.display();
    }// </editor-fold>   
}
