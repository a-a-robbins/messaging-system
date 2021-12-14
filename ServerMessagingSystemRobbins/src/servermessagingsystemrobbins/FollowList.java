package servermessagingsystemrobbins;

import java.util.ArrayList; 


/**
 *
 * @author a-a-robbins
 */

//creates and keeps an arraylist of usernames, only a structure for keeping a list
//separation of "people I am following" and "following me" are kept by User class
public class FollowList {
    
     //keywords for client
     private static final String OKAY = "OKAY"; 
     private static final String BAD = "BAD"; 
     private ArrayList <String> list;
         
      
    public FollowList() {
        list = new ArrayList();          
    } 
    
    //add username to the arraylist
    public String follow(String name) {
        list.add(name);         
      //test print
        //for(int i = 0; i < list.size(); i++) {
            //System.out.println(list); 
      //  }
      
        return name; 
    }
    
    //remove username from arraylist
    public String unfollow(String name) {
        list.remove(name); 
        return name;  
    }
    
    //return the arraylist
    public ArrayList display() {
        return list; 
    }
    
    //return size of arraylist
    public int size() {
        return list.size(); 
    }
    
    //return username at specified index
    public String get(int index) {
        return list.get(index);
    }
    
    //check if username is in the arraylist
    public boolean contains(String str) {
        return list.contains(str); 
    }

} 
