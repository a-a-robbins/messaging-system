/*
 * To change this license header, choose License Headers in Project Properties.
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
public class NotificationThread implements Runnable {
  
    
    public NotificationThread(User personDoingFollowing) {
       String address = personDoingFollowing.getAddress();        
    }
    
    
     public void run() {
            try {
            //create a host
            String host = "localhost"; 
            
            //create a socket connection
            Socket sock = new Socket(host, 2008); 
            
            //create the IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
            
            //do stuff as a protocol
            out.println("FOLLOW"); 
                        
            //get confirmation back
            if(in.nextLine().equals("OKAY")) {
                //give user following
                
                //give IP address of user following        
            }
            
            else {
            }
  
        }
        
        catch (IOException e) {            
            //print error
            System.err.println("IOEXCEPTION" + e.getMessage());
        }
    }                     

 }
    

