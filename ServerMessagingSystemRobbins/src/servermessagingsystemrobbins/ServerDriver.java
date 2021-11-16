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
import java.util.Scanner;
/**
 *
 * @author a-a-robbins
 */
public class ServerDriver {

 private UserMap map; 
 private MessageList list; 
   
   public ServerDriver(){
       map = new UserMap(); 
       list = new MessageList(); 
   }
   
    public static void main(String[] args) {
        
      ServerDriver server = new ServerDriver();
      
      
      //register and log in test users
      String name = "Miles";  // ? why can't I use the idea of this.name here ? 
      String pass = "pwd1";
      server.register(name, pass); 
      //server.logOn(name, pass); 
      
      name = "Mazie"; 
      pass = "pwd1"; 
      server.register(name, pass); 
      //server.logOn(name, pass); 
      
      //Tinkerbell is open to test bad pass log in
      name = "Tinkerbell"; 
      pass = "pwd2"; 
      server.register(name, pass); 
      
      //testing follow connection
      server.follow("Miles", "Tinkerbell");
      server.follow("Mazie", "Tinkerbell"); 
      
      
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
                        result = server.logOn(name, pass);
                        System.out.println(result);
                        out.println(result);
                        break; 
                    
                    case "Register" :
                        name = in.nextLine(); 
                        pass = in.nextLine(); 
                        //String email = in.nextLine(); 
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
                        String sendTo = in.nextLine(); 
                        String hashtag = in.nextLine(); 
                        String message = in.nextLine(); 
                        out.println("okay");                    
                        result = server.send(sendTo, hashtag, message); 
                        out.println(result);
                        break; 
                    
                    default: 
                        out.println("Whoops, something went wrong because you're getting the default message"); 
                        out.println("Expected cases: LogOn, Register, LogOff, Follow, Unfollow, Display"); 
                        break;                        
                }               
            }            
        }
        
        catch (IOException e) {
            //throw error message, perhaps write to a log later
            System.err.println(e.getMessage()); 

        }   
        
    }
    
    
  
    public String register(String name, String pass) {
        String result = map.register(name, pass); 
        return result;  
    }
    
    public String logOn(String name, String pass){
        String result = map.logOn(name, pass); 
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
    
    public String send(String sendTo, String hashtag, String message) {
        return ""; 
    }
}
