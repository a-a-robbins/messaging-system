package servermessagingsystemrobbins;

//package components; 

import java.util.ArrayList; 

        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a-a-robbins
 */

public class FollowList {
    
     //keywords for client
     private static final String OKAY = "okay"; 
     private static final String BAD = "bad"; 
     private ArrayList <String> list;
         
      
    public FollowList() {
        
        //initializing new arraylist
        list = new ArrayList();
          
    } 
    
    public String follow(String name) {
        list.add(name);         
      //test print
        //for(int i = 0; i < list.size(); i++) {
            //System.out.println(list); 
      //  }
      
        return name; 
    }
    
    public String unfollow(String name) {
        list.remove(name); 
        return name;  
    }
    
    public ArrayList display() {
        return list; 
    }
    
    public int size() {
        return list.size(); 
    }
    
    public String get(int index) {
        return list.get(index);
    }
    
    public String add(String str) {
        if(list.add(str)) {
            return str + " added"; 
        }
        else
            return "something went wrong adding to list"; 
    }
 
    public boolean contains(String str) {
        return list.contains(str); 
    }
    
   /* public ArrayList toArray() {
        return list.toArray(); 
    }*/
} 
