package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Patient {
   
    // <editor-fold defaultstate="collapsed" desc="Properties">
    private String patId;
    private String passwd;
    private String firstName;
    private String lastName;
    private String addr;
    private String email;
    private String insCo;
    private Appointment a1;
    private AppointmentList apps = new AppointmentList();// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    /**
     *
     */
    public Patient()
    {
        patId = "";
        passwd = "";
        firstName = "";
        lastName = "";
        addr = "";
        email = "";
        insCo = "";
    }
    
    /**
     *
     * @param pid
     * @param pwd
     * @param fn
     * @param ln
     * @param add
     * @param em
     * @param ins
     */
    public Patient(String pid, String pwd, String fn, String ln, String add, String em, String ins)
    {
        patId = pid;
        passwd = pwd;
        firstName = fn;
        lastName = ln;
        addr = add;
        email = em;
        insCo = ins;
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Set/Get Methods">

    /**
     *
     * This sets id to a given string
     */
    public void setPatId(String pid)
    {
        patId = pid;
    }

    /**
     *
     * This returns the patId property
     */
    public String getPatId()
    {
        return patId;
    }

    /**
     *
     * This sets password to a given string
     */
    public void setPasswd(String pwd)
    {
        passwd = pwd;
    }

    /**
     *
     * This returns the passwd property
     */
    public String getPasswd()
    {
        return passwd;
    }

    /**
     *
     * This sets FirstName to a given string
     */
    public void setFirstName(String fn)
    {
        firstName = fn;
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
     * This sets the LastName to a given string
     */
    public void setLastName(String ln)
    {
        lastName = ln;
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
     * This sets the Address to a given string
     */
    public void setAddr(String add)
    {
        addr = add;
    }

    /**
     *
     * This returns the addr property
     */
    public String getAddr()
    {
        return addr;
    }

    /**
     *
     * This sets the Email to a given string
     */
    public void setEmail(String em)
    {
        email = em;
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
     * This sets the Insurance Company to a given string
     */
    public void setInsCo(String ins)
    {
        insCo = ins;
    }

    /**
     *
     * This returns the insCo property
     */
    public String getInsCo()
    {
        return insCo;
    } 

    /**
     *
     * This returns the apps property
     */
    public AppointmentList getAppointmentList()
    {
        return apps;
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Database Connection Methods">

    /**
     * This is the method that pulls all 
     * of the information from the database and puts it into the properties for the class.
     */
    public void selectDB(String pid)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql = "Select * from Patients where patId='" + pid + "'";
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        
        setPatId(rs.getString(1));
        setPasswd(rs.getString(2));
        setFirstName(rs.getString(3));
        setLastName(rs.getString(4));
        setAddr(rs.getString(5));
        setEmail(rs.getString(6));
        setInsCo(rs.getString(7));
        
        getAppointments(getPatId());
        
        con.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    /**
     *
     * This method will take some parameters and use them to 
     * update the Patient table in the database with the given information.
     */
    public void updateDB(String pid, String pwd, String fn, String ln, String add, String em, String ins)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE Patients SET passwd = ?, firstName = ?, lastName = ?, addr = ?, email = ?, insCo = ? WHERE patId = ?");
        ps.setString(1, pwd);
        ps.setString(2, fn);
        ps.setString(3, ln);
        ps.setString(4, add);
        ps.setString(5, em);
        ps.setString(6, ins);
        ps.setString(7, pid);
        
        ps.executeUpdate();
        ps.close();
        con.close();
        selectDB(pid);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
        
    /**
     *
     * This will delete any entry in the Patient table in the database with the given patient id
     */
    public void deleteDB(String pid)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql = "DELETE FROM Patients WHERE patId = '" + pid + "'";
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
     * This creates an AppointmentList that holds all of the appointments for a given patient
     * and adds it to the AppointmentList property.
     */
    public void getAppointments(String id)
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
            String sql="Select patId from Appointments where patId ='"+ id +"'";
            Statement stmt = con.createStatement();
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
        
            while(rs.next())
            {
                String pid = rs.getString(1);
                a1 = new Appointment();
                a1.selectDB(pid);
                apps.addAppointment(a1);
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
        System.out.println("PatId: " + getPatId());
        System.out.println("Passwd: " + getPasswd());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Address: " + getAddr());
        System.out.println("Email: " + getEmail());
        System.out.println("Insurance Company: " + getInsCo());
    }
    
    /**
     *
     * This is a standard main method for debugging
     */
    public static void main(String args[])
    {
        Patient p1 = new Patient();
        p1.selectDB("A900");
        p1.updateDB("A900", "8888", "Jimmy", "Hawkins", "Marietta", "jhawk@yahoo.com", "Cigna");
        p1.display();
    }// </editor-fold>                
}