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
public class Appointment 
{
    // <editor-fold defaultstate="collapsed" desc="Properties">
    private String apptDateTime;
    private String patId;
    private String dentId;
    private String procCode; // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Appointment()
    {
        apptDateTime = "";
        patId = "";
        dentId = "";
        procCode = "";
    }
    
    public Appointment(String adt, String pid, String did, String prcc)
    {
        apptDateTime = adt;
        patId = pid;
        dentId = did;
        procCode = prcc;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Set/Get Methods">
    public void setApptDateTime(String adt)
    {
        apptDateTime = adt;
    }
    public String getApptDateTime()
    {
        return apptDateTime;
    }
    public void setPatId(String pid)
    {
        patId = pid;
    }
    public String getPatId()
    {
        return patId;
    }
    public void setDentId(String did)
    {
        dentId = did;
    }
    public String getDentId()
    {
        return dentId;
    }
    public void setProcCode(String prcc)
    {
        procCode = prcc;
    }
    public String getProcCode()
    {
        return procCode;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Database Connection Methods">
    public void selectDB(String pid)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql="Select * from Appointments where patId ='"+ pid +"'";
        Statement stmt = con.createStatement();
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        
        setApptDateTime(rs.getString(1));
        setPatId(rs.getString(2));
        setDentId(rs.getString(3));
        setProcCode(rs.getString(4));
        con.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
    public void updateDB(String adt, String pid, String did, String prcc)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE Appointments SET apptDateTime = ?, dentId = ?, procCode = ? WHERE patId = ?");
        ps.setString(1, adt);
        ps.setString(2, did);
        ps.setString(3, prcc);
        ps.setString(4, pid);
        
        ps.executeUpdate();
        ps.close();
        con.close();
        selectDB(getPatId());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void deleteDB(String pid)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        String sql = "DELETE FROM Appointments WHERE patId = '" + pid + "'";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        con.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void insertDB(String adt, String pid, String did, String prcc)
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Java3DB2");
        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO Appointments(apptDateTime, patId, dentId, procCode) VALUES(?, ?, ?, ?)");
        ps.setString(1, adt);
        ps.setString(2, pid);
        ps.setString(3, did);
        ps.setString(4, prcc);
        
        ps.executeUpdate();
        ps.close();
        con.close();
        selectDB(getPatId());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void display()
    {
        System.out.println("Appointment Date/Time: " + getApptDateTime());
        System.out.println("Patient ID: " + getPatId());
        System.out.println("Dentist ID: " + getDentId());
        System.out.println("Procedure Code: " + getProcCode());
        System.out.println("============================================");
    }// </editor-fold>
    
}
