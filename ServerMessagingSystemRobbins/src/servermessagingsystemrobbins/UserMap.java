/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.net.InetAddress;
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
        String result; 
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
    
    public String logOn(String name, String pass, InetAddress address) {
        String result;
        if(theUsers.containsKey(name)) {
             User u = theUsers.get(name); 
                if(u.getPass().equals(pass) && u.checkStatus() == false) {
                    result = "valid log on"; 
                    u.setStatus(true);
                    u.setAddress(address); 
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
        //FIXME: check status before logging off (make sure they are already logged on)
        //FIXME: make sure you are logging off a valid user
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
    
    public String follow(String personDoingFollowing, String personBeingFollowed) {
       String result; 
        
       //check for valid user 
       if(theUsers.containsKey(personDoingFollowing) && theUsers.containsKey(personBeingFollowed)) {
            User doingFollowing = theUsers.get(personDoingFollowing); 
            User beingFollowed = theUsers.get(personBeingFollowed); 
            
            result = doingFollowing.toFollow(personBeingFollowed);
            String result2 = beingFollowed.beingFollow(personDoingFollowing); 
       }
       else {
           result = "User " + personBeingFollowed + " does not exist, please verify input"; 
       }

       return result; 
    }
   
    
    public String unfollow(String personDoingUnfollowing, String personBeingUnfollowed) {
       String result;  
        //CHECK FOR VALID USER
       if(theUsers.containsKey(personDoingUnfollowing) && theUsers.containsKey(personBeingUnfollowed)) {
            User doingUnfollowing = theUsers.get(personDoingUnfollowing); 
            User beingUnfollowed = theUsers.get(personBeingUnfollowed); 
            
            result = doingUnfollowing.toUnfollow(personBeingUnfollowed);  
            beingUnfollowed.beingUnfollowed(personDoingUnfollowing);         
       }
       else {
           result = "User " + personBeingUnfollowed + " does not exist, please verify input"; 
       }

        return result; 
    }
    
    public FollowList display(String name, String type) {
        User u = theUsers.get(name); 
        FollowList result = u.display(type);
            //TEST: FollowList results
            System.out.println("FollowList from User: " + result); 
        return result; 
    }
    
    public boolean verifyUser(String name) {
      if(theUsers.containsKey(name)) {
         return true;  
      }
      else {
          return false;
      } 
    }
    
    public User getUser(String name) {
            User u = theUsers.get(name);
            
            return u; 
    }
}
