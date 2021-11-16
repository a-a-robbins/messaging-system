/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanAsh4Ever
 */
public class GUIUser {
    
    private String name; 
    private String pass; 
    private boolean status; 
    
    public GUIUser(String name) {
        this.name = name; 
        //this.pass = pass; 
        this.status = true; 
    }
    
    public void setName(String n) {
        name = n; 
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
