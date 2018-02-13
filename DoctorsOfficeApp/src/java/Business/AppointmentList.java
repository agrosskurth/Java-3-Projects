/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Andrew
 */
public class AppointmentList 
{ 
    public Appointment[] alist = new Appointment[10];
    private int count = 0;
    
    public Appointment[] getApps()
    {
        return alist;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void addAppointment(Appointment a1)
    {
        alist[count] = a1;
        count++;
    }
    
    public void display()
    {
        for(int i = 0; i <= (count-1); i++)
        {
            alist[i].display();
        }
    }
}