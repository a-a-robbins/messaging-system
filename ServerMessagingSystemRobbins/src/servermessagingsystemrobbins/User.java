/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagingsystemrobbins;

import java.net.InetAddress;

/**
 *
 * @author a-a-robbins
 */
public class User {
    
    private String name; 
    private String pass; 
    private String address;  
    private boolean status; 
    private FollowList peopleIAmFollowing = new FollowList(); 
    private FollowList peopleFollowingMe = new FollowList(); 
    
    
    //create a new user
    public User(String name, String pass) {
        this.name = name; 
        this.pass = pass; 
        this.status = false; 
    }
    
    //return username
    public String getName() {
        return name; 
    }
    
    //return password
    public String getPass() {
        return pass; 
    }
    
    //return IP address
    public String getAddress() {
        return address; 
    }
    
    
    //set user IP address
    public String setAddress(InetAddress addy) {
        address = addy.toString();
        address = address.substring(1); 
//        //TEST: did our address set
//        System.out.println(address);
        return address; 
    }
    
    //set user log in status
    public boolean setStatus(boolean stat) {
        status = stat;
            //testing invalid log off
                //status = true; 
        return status; 
    }
  
    //return rather online or not
    public boolean checkStatus() {
        return status; 
    }

    //check to see if already following and add person being followed
    //to "people I am following" list of user wanting to do follow
    public String toFollow(String personToFollow) {
       String result; 
       
       if(!peopleIAmFollowing.contains(personToFollow)) {
          result = peopleIAmFollowing.follow(personToFollow); 
       } 
       else {
           result = "You are already following " + personToFollow; 
       }
      
       return result;

    }
    
    //check to see if already being followed and add person doing 
    //following to the "following me" list of user being followed
    public String beingFollow(String personDoingFollow) {
        String result; 
        
      if(!peopleFollowingMe.contains(personDoingFollow)) {
         result = peopleFollowingMe.follow(personDoingFollow);
            if(result.equals(personDoingFollow + "added")) {
                return result; 
             }
      }
      else {
          result = "This person is already being followed by you"; 
      }
        
       return result; 
    }
    
    //verify already following and then remove user from their
    //"people I am following" list
    public String toUnfollow(String personToUnfollow) {
        String result; 
        
        if(peopleIAmFollowing.contains(personToUnfollow)) {
           result = peopleIAmFollowing.unfollow(personToUnfollow); 
        }
        else { 
            result = "You are not yet following " + personToUnfollow; 
        } 
        
        return result;
    }
    
    //verify they were being followed and then remove user from 
    //their "following me" list
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
    
    //intake type of list to display and return list   
    public FollowList display(String type) {
       switch(type) {
            case "peopleIAmFollowing" :
                return peopleIAmFollowing; 
             
            case "peopleFollowingMe" :
                return peopleFollowingMe; 
                 
            default: 
                FollowList empty = new FollowList(); 
                empty.follow("bad command, missing data"); 
                return empty; 

       } 
    }

}
