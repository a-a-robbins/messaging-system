/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servermessagingsystemrobbins;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
//import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author a-a-robbins
 */

//FIXME: consistently use "okay" in server protocol (put right after getting protocol)
//update the methods with appropriate if/else check

public class ServerDriver {

 private UserMap map; 
 private ArrayList mList;
 private MessageList2 list;  
   
   public ServerDriver(){
       map = new UserMap(); 
       mList = new ArrayList<Message>();
       list = new MessageList2(); 
   }
   
    public static void main(String[] args) {
        
      ServerDriver server = new ServerDriver();
      //TEST: see if adding stuff will change build version
      System.out.println("Test in main at ServerDriver --- Delete me!");
      
      //TEST: register and log in test users
      String name = "Miles";
      String pass = "pwd1"; 
      server.register(name, pass); 
      //server.logOn(name, pass); 
      
      name = "Mazie"; 
      pass = "pwd1"; 
      server.register(name, pass); 
      //server.logOn(name, pass); 
      
      name = "Tinkerbell"; 
      pass = "pwd2"; 
      server.register(name, pass); 
      
      //TEST:  follow connection
      server.follow("Miles", "Tinkerbell");
      server.follow("Miles", "Mazie"); 
      server.follow("Mazie", "Tinkerbell");
      
      //TEST:  historical messages
      server.send("Mazie", "past", "test message from Mazie", LocalDate.parse("2021-10-30"));      
      server.send("Miles", "past", "test message from Miles", LocalDate.parse("2020-05-02"));
      server.send("Tinkerbell", "past", "test message from Tinkerbell", LocalDate.parse("2020-05-03"));
      //TEST: future messages should not show up
      server.send("Tinkerbell", "future", "test message in future from Tinkerbell", LocalDate.parse("2021-12-22"));
      server.send("Miles", "future", "test message in future from Miles", LocalDate.parse("2044-03-29"));
      server.send("Tinkerbell", "future", "test message in future #2 from Tinkerbell", LocalDate.parse("2052-01-01"));
            
      
      String result; 
        
        try {
            
            //create server socket so we can listen for incoming connections
            ServerSocket listen = new ServerSocket(2001); 
            
            //display the port# we are listening on
            System.out.println("Listening on port: " + listen.getLocalPort()); 
            //display address we are listening on
            System.out.println("Listening on address: " + InetAddress.getLocalHost()); 
            
            
            //initiate a never-ending process cycle
            while(true) {
                
                //wait for a client to connect
                Socket client = listen.accept(); 
                
                //get IO stream
                PrintWriter out = new PrintWriter(client.getOutputStream(), true); 
                Scanner in = new Scanner(client.getInputStream()); 
                
                //create a protocol
                String protocol = in.nextLine(); 
                
                //start switch statements and use CONSTANTS declared for the string
                switch(protocol) {
                    case "LogOn" :
                        name = in.nextLine();
                        pass = in.nextLine();
                        InetAddress address = client.getInetAddress(); 
                        result = server.logOn(name, pass, address);
                        //TEST: what is the user's address
                        System.out.println(result);
                        out.println(result);
                        break; 
                    
                    case "Register" :
                        name = in.nextLine(); 
                        pass = in.nextLine();
                       // address = client.getInetAddress(); 
                        result = server.register(name, pass);
                        System.out.println(result);
                        out.println(result);
                        break; 
                       
                    case "LogOff" :
                        name = in.nextLine(); 
                        result = server.logOff(name); 
                        System.out.println(result);
                        out.println(result); 
                        break;  
                        
                    case "Follow" : 
                        String personDoingFollowing = in.nextLine(); 
                        String personBeingFollowed = in.nextLine(); 
                        out.println("okay");                    
                        result = server.follow(personDoingFollowing, personBeingFollowed); 
                        out.println(result);
                        User u = server.getUser(personBeingFollowed); 
                        NotificationThread nt = new NotificationThread(u, personDoingFollowing); 
                        Thread t = new Thread(nt); 
                        t.start(); 
                        break; 
                     
                    case "Unfollow" :
                        String currentUser = in.nextLine(); 
                        String personToUnfollow = in.nextLine(); 
                        out.println("okay");                    
                        result = server.unfollow(currentUser, personToUnfollow); 
                        out.println(result);
                        break; 
                        
                    case "Display" :
                        name = in.nextLine(); 
                        String type = in.nextLine(); 
                        out.println("okay");
                        FollowList displayList = server.display(name, type);
                        out.println(Integer.toString(displayList.size()));
                            for(int i = 0; i < displayList.size(); i++) {
                                out.println(displayList.get(i));
                            }
                        break; 
                        
                     case "Send" :
                        String sender = in.nextLine(); 
                        String hashtag = in.nextLine(); 
                        String message = in.nextLine();
                        LocalDate timestamp = LocalDate.now();    
                        out.println("okay"); 
                        System.out.println("timestamp = " + timestamp); 
                        result = server.send(sender, hashtag, message, timestamp); 
                        out.println(result);
                        break; 
                        
                     case "Unread" : 
                        name = in.nextLine(); 
                        timestamp = LocalDate.now();                        
                        out.println("okay"); 
                        MessageList2 m = server.retrieve("Unread", name, timestamp );
                        out.println(Integer.toString(m.size()));
                            for(int i = 0; i < m.size(); i++) {
                                out.println(m.get(i));
                            }
                        break;
                     
                     case "Search" :
                         timestamp = LocalDate.now(); 
                         String keyword = in.nextLine(); 
                         out.println("okay");
                         m = server.retrieve("Search", keyword, timestamp); 
                         out.println(Integer.toString(m.size())); 
                            for(int i = 0; i < m.size(); i++) {
                                out.println(m.get(i)); 
                            }
                         break;
                         
                     case "Get" :
                         name = in.nextLine(); 
                         if(server.verifyUser(name) == true) {
                           u = server.getUser(name);
                          System.out.println("User to get info for: " + u.getName()); 
                                if(u.getStatus() == true) {
                                   out.println("okay"); 
                                   String ip = u.getAddress();
                                   //TEST: address sent
                                   System.out.println("The address for user " + u.getName() + " is: " + ip); 
                                   out.println(ip);                            
                                }
                                else {
                                    out.println("offline"); 
                                }
                         }
                         else {
                            out.println("not a valid user"); 
                         }
                         //TEST: what user did we get

 
                         break; 
                    
                    default: 
                        out.println("Whoops, something went wrong because you're getting the default message"); 
                        out.println("Expected cases: LogOn, Register, LogOff, Follow, Unfollow, Display, Send, Unread, Search, or Get"); 
                        break;                        
                }               
            }            
        }
        
        catch (IOException e) {
            //throw error message, perhaps write to a log later
            System.err.println("IOException in ServerDriver: " + e.getMessage()); 

        }   
        
    }
    
    
  
    public String register(String name, String pass) {
        String result = map.register(name, pass); 
        return result;  
    }
    
    public boolean verifyUser(String name) {
        return map.verifyUser(name); 
    }
    public User getUser(String name) {
        return map.getUser(name); 
    }
    
    public String logOn(String name, String pass, InetAddress address){
        String result = map.logOn(name, pass, address); 
        return result; 
    }
    
    public String logOff(String name) {
        String result = map.logOff(name); 
        return result; 
    }
    
    public String follow(String personDoingFollowing, String personBeingFollowed) {
        String result = map.follow(personDoingFollowing, personBeingFollowed); 
        return result; 
    }
    
    public String unfollow(String personDoingUnfollowing, String personBeingUnfollowed) {
        String result = map.unfollow(personDoingUnfollowing, personBeingUnfollowed); 
        return result; 
    }
    
    public FollowList display(String name, String type) {
        FollowList result = map.display(name, type); 
        return result;
    }
    
    public String send(String sender, String hashtag, String message, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(sender) == true) {
           //User u = map.getUser(sender); 
           String result = list.send(sender, hashtag, message, timestamp); 
           return result; 
           }
       
        else {
            return "Something went wrong in the send function"; 
        }  
    }
    
    public MessageList2 retrieve(String keyword, String name, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(name) == true);
        FollowList followingList = map.display(name, "peopleIAmFollowing");
            //TEST: FollowList returning appropriately
            System.out.println("FollowList returned in retrive method: " + followingList); 
        MessageList2 mL = list.retrieve(keyword, followingList, timestamp);
        return mL;         
    }
    
    public MessageList2 search(String keyword, String name, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(name) == true); 
            MessageList2 mL = list.search(keyword, timestamp);
            return mL;
        
    }
    
}
