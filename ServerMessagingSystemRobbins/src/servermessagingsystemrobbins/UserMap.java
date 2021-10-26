/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.util.HashMap;

/**
 *
 * @author a-a-robbins
 */
public class UserMap {
    
    private HashMap<String,User> theUsers; 
    
   
    public UserMap() {
        theUsers = new HashMap<>(); 
    }
    
    public String register(String name, String pass) {
        String result = ""; 
        if(!theUsers.containsKey(name)) {
            User newUser = new User(name, pass); 
            theUsers.put(name, newUser); 
            result = "registration success!";  
        }
        else {
            result = "registration invalid, user name already exists :( "; 
        }
        
        return result; 
    }
    
    public String logOn(String name, String pass) {
        String result;
        if(theUsers.containsKey(name)) {
             User u = theUsers.get(name); 
                if(u.getPass().equals(pass) && u.checkStatus() == false) {
                    result = "valid log on"; 
                    u.setStatus(true);                 
                }
                else if(!u.getPass().equals(pass)) {
                    result = "invalid log on, passwords don't match";                  
                }            
                else {
                    result = "invalid log on, user already logged in"; 
                }
        }
        else {
             result = "invalid log on, no such user";    
        }
       
        return result; 
    }
    
    public String logOff(String name) {
        String result; 
        //check status before logging off (make sure they are already logged on)
        //make sure you are logging off a valid user
        User u = theUsers.get(name); 
        u.setStatus(false);
            if(!u.checkStatus()) {
                result = "successful log off"; 
            }
            else {
                result = "whoops, something went wrong --- you're still logged on!"; 
            }
        return result; 
    }
}
