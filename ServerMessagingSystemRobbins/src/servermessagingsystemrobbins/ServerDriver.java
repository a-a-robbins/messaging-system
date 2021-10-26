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

   //private String name = ""; //since these are being passed through main and they need to be static, should they be local to main?
  // private String pass = ""; 
  // private String address; 
   private UserMap map; 
   
   public ServerDriver(){
       map = new UserMap(); 
   }
   
    public static void main(String[] args) {
        
      ServerDriver server = new ServerDriver();
      
      
      //register and log in test users
      String name = "Miles";  // ? why can't I use the idea of this.name here ? 
      String pass = "pwd1";
      server.register(name, pass); 
      server.logOn(name, pass); 
      
      name = "Mazie"; 
      pass = "pwd1"; 
      server.register(name, pass); 
      server.logOn(name, pass); 
      
      //Tinkerbell is open to test bad pass log in
      name = "Tinkerbell"; 
      pass = "pwd2"; 
      server.register(name, pass); 
      
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
                    
                    default: 
                        System.out.println("Whoops, something went wrong because you're getting the default message"); 
                        System.out.println("Expected cases: LogOn, Register, or LogOff"); 
                        break;                        
                        
                }               
            }            
        }
        
        catch (IOException e) {
            //throw error message, perhaps write to a log later
            System.err.println(e.getMessage()); 
        }   
        
        
        
       /* THIS IS ALL TESTING METHODS WITH NO CONNECTION
        ServerDriver server = new ServerDriver();
        String name = "Miles";  // ? why can't I use the idea of this.name here ? 
        String pass = "pwd1"; 
        
        
        //testing registration
        String conf = server.register(name, pass);
        System.out.println(conf);
      
        //testing for invalid registration (same name)
        conf = server.register(name, pass); 
        System.out.println(conf); 
               
        //testing for valid log in
        String result = server.logOn(name, pass);
        System.out.println(result); 
        
        //testing for invalid log in (bad password)
        result = server.logOn(name, "notThePassword"); 
        System.out.println(result); 

        //testing for invalid log in (bad username)
        result = server.logOn("Mazie", pass); 
        System.out.println(result); 
        
        //testing for invalid log in (bad pass and bad name)
        result = server.logOn("Mazie", "notThePassword"); 
        System.out.println(result); 
        
        //testing log off
        result = server.logOff(name); 
        System.out.println(result); 
*/
        
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
    
}
