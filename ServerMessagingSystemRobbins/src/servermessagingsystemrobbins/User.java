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
    private FollowList peopleIAmFollowing = new FollowList(); 
    private FollowList peopleFollowingMe = new FollowList(); 
    
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
    
    
    //ONLY NEED USER IN THE USER MAP -- EVERYTHING ELSE CAN BE DONE STRINGS
    
    public String toFollow(String personToFollow) {
       String result; 
       
       //CHECK TO SEE IF ALREADY FOLLOWING
       if(!peopleIAmFollowing.contains(personToFollow)) {
          result = peopleIAmFollowing.follow(personToFollow); 
       } 
       else {
           result = "You are already following " + personToFollow; 
       }
      
       return result;

    }
    
    public String beingFollow(String personDoingFollow) {
        String result; 
        
      //CHECK TOO SEE IF ALREADY FOLLOWING
      if(!peopleFollowingMe.contains(personDoingFollow)) {
         result = peopleFollowingMe.follow(personDoingFollow);
      }
      else {
          result = "This person is already being followed by you"; 
      }
        
       return result; 
    }
    
    public String toUnfollow(String personToUnfollow) {
        String result; 
        
        //check to see if following
        if(peopleIAmFollowing.contains(personToUnfollow)) {
           result = peopleIAmFollowing.unfollow(personToUnfollow); 
        }
        else { 
            result = "You are not yet following " + personToUnfollow; 
        } 
        
        return result;
    }
    
    public String beingUnfollowed(String personDoingUnfollowing) {
        String result; 
        //check to see if following
        if(peopleFollowingMe.contains(personDoingUnfollowing)) {
            result = peopleFollowingMe.unfollow(personDoingUnfollowing); 
        }
        else { 
            result = personDoingUnfollowing + " is not being followed by you";
        }
        return result; 
    }
    
       
    public FollowList display(String type) {
       switch(type) {
            case "peopleIAmFollowing" :
                return peopleIAmFollowing; 
             
            case "peopleFollowingMe" :
                return peopleFollowingMe; 
                 
            default: 
                FollowList empty = new FollowList(); 
                empty.add("bad command, missing data"); 
                return empty; 

       
       }
        
    }
}
