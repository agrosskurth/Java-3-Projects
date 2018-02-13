package Business;


import Business.Account;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class AccountList {
    
    public Account[] alist = new Account[10];
    private int count = 0;
    
    public Account[] getAccs()
    {
        return alist;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void addAccount(Account a1)
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
