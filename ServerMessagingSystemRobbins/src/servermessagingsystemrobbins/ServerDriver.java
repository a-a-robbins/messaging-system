package servermessagingsystemrobbins;

import static com.sun.tools.javac.tree.TreeInfo.name;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author a-a-robbins
 */


public class ServerDriver {

 private UserMap map; 
 private ArrayList mList;
 private MessageList2 list; 
 private static final String LOGON = "LOGON";  
 private static final String REGISTER = "REGISTER"; 
 private static final String LOGOFF = "LOGOFF"; 
 private static final String FOLLOW = "FOLLOW"; 
 private static final String UNFOLLOW = "UNFOLLOW"; 
 private static final String DISPLAY = "DISPLAY"; 
 private static final String SEND = "SEND";
 private static final String UNREAD = "UNREAD"; 
 private static final String REFRESH = "REFRESH"; 
 private static final String SEARCH = "SEARCH"; 
 private static final String GET = "GET"; 
 private static final String CONF = "OKAY"; 

   
   public ServerDriver(){
       map = new UserMap(); 
       mList = new ArrayList<Message>();
       list = new MessageList2(); 
   }
   
    public static void main(String[] args) {
        
      ServerDriver server = new ServerDriver();
       
//      //TEST: see if adding stuff will change build version
//      System.out.println("Test in main at ServerDriver --- Delete me!");
      
     //only need try/catch if logging a user on in the test section
      try {
      //TEST: register and log in test users
      String name = "Miles";
      String pass = "pwd1"; 
      server.register(name, pass); 
      server.logOn(name, pass, InetAddress.getLocalHost()); 
        System.out.println("Miles logged on");      
      
      name = "Mazie"; 
      pass = "pwd1"; 
      server.register(name, pass); 
//      server.logOn(name, pass, InetAddress.getLocalHost()); 
//        System.out.println("Mazie logged on"); 
      
      name = "Tinkerbell"; 
      pass = "pwd2"; 
      server.register(name, pass); 
      server.logOn(name, pass, InetAddress.getLocalHost());
        System.out.println("Tinkerbell logged on"); 
      
      //TEST:  follow connection
      server.follow("Miles", "Tinkerbell");
      server.follow("Miles", "Mazie"); 
      server.follow("Mazie", "Tinkerbell");
      
      //TEST:  historical messages (only works if users are already logged in)
      server.send("Mazie", "past", "test message from Mazie", LocalDate.parse("2021-10-30"));      
      server.send("Miles", "past", "test message from Miles", LocalDate.parse("2020-05-02"));
      server.send("Tinkerbell", "past", "test message from Tinkerbell", LocalDate.parse("2020-05-03"));
      //TEST: future messages should not show up
      server.send("Tinkerbell", "future", "test message in future from Tinkerbell", LocalDate.parse("2021-12-22"));
      server.send("Miles", "future", "test message in future from Miles", LocalDate.parse("2044-03-29"));
      server.send("Tinkerbell", "future", "test message in future #2 from Tinkerbell", LocalDate.parse("2052-01-01"));
            
      }
      
      //only need when logging on in test section above
      catch(UnknownHostException uh) {
          System.err.println("UnknownHostException in ServerDriver: " + uh.getMessage());
      }
      
      
      String result; 
      String name; 
      String pass; 
        
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
                
//                //TEST: received protocol
//                System.out.println("Protocol received by server: " + protocol); 
                
                //start switch statements and use CONSTANTS declared for the string
                switch(protocol) {
                    
                    //get username, password, and IP address -- verify validity
                    case LOGON :
                        name = in.nextLine();
                        pass = in.nextLine();
                        InetAddress address = client.getInetAddress(); 
                        result = server.logOn(name, pass, address);
//                        //TEST: what is the user's address
//                        System.out.println(result);
                        out.println(result);
                        break; 
                        
                    //register a new user with username and password
                    case REGISTER :
                        name = in.nextLine(); 
                        pass = in.nextLine();
                        result = server.register(name, pass);
//                        TEST: what was result
//                        System.out.println(result);
                        out.println(result);
                        break; 
                        
                    //verify user is logged on and then complete log off request   
                    case LOGOFF :
                        name = in.nextLine(); 
                        User u = server.getUser(name); 
                        if(server.verifyUser(name) == true && u.checkStatus() == true){
                           result = server.logOff(name);
//                           TEST: what was result
//                           System.out.println(result);
                           out.println(result);  
                        }  
                        break;  
                        
                    //verify users are valid and not trying to follow self then complete follow request    
                    case FOLLOW : 
                        String personDoingFollowing = in.nextLine(); 
                        String personBeingFollowed = in.nextLine();
                        u = server.getUser(personDoingFollowing); 
                        out.println(CONF); 
                        if(server.verifyUser(personDoingFollowing) && server.verifyUser(personBeingFollowed) && !personDoingFollowing.equals(personBeingFollowed) && u.checkStatus() == true) {
                                result = server.follow(personDoingFollowing, personBeingFollowed); 
                                out.println(result);
                                u = server.getUser(personBeingFollowed); 
                                NotificationThread nt = new NotificationThread(u, personDoingFollowing); 
                                Thread t = new Thread(nt); 
                                t.start();
                        }
                        else if(personDoingFollowing.equals(personBeingFollowed)) {
                            out.println("Sorry stud, you can't follow yourself");
                        }
                        else {
                            out.println("User does not exist"); 
                        }
                     
                        break; 
                        
                    //verify user requesting is valid and logged on then complete unfollow request 
                    case UNFOLLOW :
                        String currentUser = in.nextLine(); 
                        String personToUnfollow = in.nextLine();
                        if(server.verifyUser(currentUser) && server.verifyUser(personToUnfollow)) {
                            u = server.getUser(currentUser); 
                            out.println(CONF);
                            if(u.checkStatus() == true) {
                                result = server.unfollow(currentUser, personToUnfollow); 
                                out.println(result);  
                            }   
                        }
                        else if(!server.verifyUser(currentUser)) {
                            out.println("You are not a valid user"); 
                        }
                        else {
                            out.println(personToUnfollow + " is not a valid user, please verify input"); 
                        }

                        break; 
                        
                    //display a list of followers    
                    case DISPLAY :
                        name = in.nextLine(); 
                        String type = in.nextLine(); 
                        out.println(CONF);
                        FollowList displayList = server.display(name, type);
                        out.println(Integer.toString(displayList.size()));
                            for(int i = 0; i < displayList.size(); i++) {
                                out.println(displayList.get(i));
                            }
                        break;
                        
                     //get message information, add a LocalDate object and send public message   
                     case SEND :
                        String sender = in.nextLine(); 
                        String hashtag = in.nextLine(); 
                        String message = in.nextLine();
                        LocalDate timestamp = LocalDate.now();    
                        out.println(CONF); 
//                        TEST: what was our timestamp
//                        System.out.println("timestamp = " + timestamp); 
                        result = server.send(sender, hashtag, message, timestamp); 
                        out.println(result);
                        break; 
                        
                     //retrieve public messages prior to current LocalDate object   
                     case UNREAD : 
                        name = in.nextLine(); 
                        timestamp = LocalDate.now();                        
                        out.println(CONF); 
                        MessageList2 m = server.retrieve(UNREAD, name, timestamp );
                        out.println(Integer.toString(m.size()));
                            for(int i = 0; i < m.size(); i++) {
                                out.println(m.get(i));
                            }
                        break;
                        
                     //retrieve public messages sent between log on and current LocalDate 
                     //will no longer display messages that were initally in UNREAD
                     case REFRESH :
                        name = in.nextLine(); 
                        timestamp = LocalDate.now();                        
                        out.println(CONF); 
                        m = server.retrieve(REFRESH, name, timestamp );
                        out.println(Integer.toString(m.size()));
                            for(int i = 0; i < m.size(); i++) {
                                out.println(m.get(i));
                            }
                        break; 
                        
                     //search by keyword for any public messages matching criteria
                     //LocalDate is only used because it is needed to create a MessageList2
                     case SEARCH :
                         timestamp = LocalDate.now(); 
                         String keyword = in.nextLine(); 
                         //TEST: what's our keyword
//                         System.out.println("Keyword = " + keyword); 
                         out.println(CONF);
                         m = server.search(keyword, SEARCH, timestamp); 
//                         TEST: did we get a message list
//                         System.out.println("size of messageList m = " + m.size()); 
                         out.println(Integer.toString(m.size())); 
                            for(int i = 0; i < m.size(); i++) {
                                out.println(m.get(i)); 
                            }
                         break;
                         
                     //verify a user is valid and retrieve their information    
                     case GET :
                         name = in.nextLine(); 
                         if(server.verifyUser(name) == true) {
                           u = server.getUser(name);
//                          //TEST: what user are we obtaining
//                           System.out.println("User to get info for: " + u.getName()); 
                                if(u.checkStatus() == true) {
                                   out.println(CONF); 
                                   String ip = u.getAddress();
//                                   //TEST: address sent
//                                   System.out.println("The address for user " + u.getName() + " is: " + ip); 
                                   out.println(ip);                            
                                }
                                else {
                                    out.println("offline"); 
                                }
                         }
                         else {
                            out.println("not a valid user"); 
                         }
 
                         break; 
                    
                    default: 
                        out.println("Whoops, something went wrong because you're getting the default message"); 
                        out.println("Expected cases: LogOn, Register, LogOff, Follow, Unfollow, Display, Send, Unread, Search, or Get"); 
                        break;                        
                }               
            }            
        }
        
        //catch connection issues with our server
        catch (IOException e) {
            System.err.println("IOException in ServerDriver: " + e.getMessage()); 

        }   
        
    }
    
    
    //access UserMap to complete register request
    public String register(String name, String pass) {
        String result = map.register(name, pass); 
        return result;  
    }
    
    //access UserMap to verify user
    public boolean verifyUser(String name) {
        return map.verifyUser(name); 
    }
    
    //access UserMap to get user
    public User getUser(String name) {
        return map.getUser(name); 
    }
    
    //access UserMap to complete log on request
    public String logOn(String name, String pass, InetAddress address){
        String result = map.logOn(name, pass, address); 
        return result; 
    }
    
    //access UserMap to complete logoff request
    public String logOff(String name) {
        String result = map.logOff(name); 
        return result; 
    }
    
    //access UserMap to complete follow request
    public String follow(String personDoingFollowing, String personBeingFollowed) {
        String result = map.follow(personDoingFollowing, personBeingFollowed); 
        return result; 
    }
    
    //access UserMap to complete unfollow request
    public String unfollow(String personDoingUnfollowing, String personBeingUnfollowed) {
        String result = map.unfollow(personDoingUnfollowing, personBeingUnfollowed); 
        return result; 
    }
    
    //access UserMap to get list of followers
    public FollowList display(String name, String type) {
        FollowList result = map.display(name, type); 
        return result;
    }
    
    //access UserMap to complete public message send request
    public String send(String sender, String hashtag, String message, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(sender) == true) {
           User u = map.getUser(sender);
           if(u.checkStatus() == true) {
                 String result = list.send(sender, hashtag, message, timestamp); 
                 return result;
            }
           else{
               return "Cannot send a message while not logged on"; 
           }
            
         }       
        else {
            return "Something went wrong in the send function"; 
        }  
    }
    
    //access UserMap to verify user and get follower list then create a MessageList2 object and populate
    public MessageList2 retrieve(String keyword, String name, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(name) == true);
        FollowList followingList = map.display(name, "peopleIAmFollowing");
//            //TEST: FollowList returning appropriately
//            System.out.println("FollowList returned in retrive method: " + followingList); 
        MessageList2 mL = list.retrieve(keyword, followingList, timestamp);
        return mL;         
    }
    
    //access UserMap to verify user then create a MessageList2 object and populate based on search term
    public MessageList2 search(String keyword, String name, LocalDate timestamp) {
        //check for registered user
        if(map.verifyUser(name) == true); 
            MessageList2 mL = list.search(keyword, timestamp);
            
//            //TEST: what size is our messageList
//            System.out.println("MessageList returned to server from Search size = " + mL.size()); 
            return mL;
        
    }
    
}
