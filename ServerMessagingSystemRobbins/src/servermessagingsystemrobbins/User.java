/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

/**
 *
 * @author a-a-robbins
 */
public class User {
    
    private String name; 
    private String pass; 
    private boolean status; 
    
    public User(String name, String pass) {
        this.name = name; 
        this.pass = pass; 
        this.status = false; 
    }
    
    public String getName() {
        return name; 
    }
    
    public String getPass() {
        return pass; 
    }
    
    public boolean getStatus() {
        return status; 
    }
    
    public boolean setStatus(boolean stat) {
        status = stat;
            //testing invalid log off
                //status = true; 
        return status; 
    }
  
    public boolean checkStatus() {
        return status; 
    }
    
}
