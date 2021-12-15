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
    private String address; 
    private String name; 
    private User personBeingFollowed;
    private static final String FOLLOW = "FOLLOW"; 
    private static final String CONF = "OKAY"; 
    
    public NotificationThread(User personBeingFollowed, String personDoingFollowing) {
        this.personBeingFollowed = personBeingFollowed; 
        address = personBeingFollowed.getAddress(); 
        name = personDoingFollowing; 
    }
    
    
     public void run() {
            try {
            //create a host
            String host = address;
            
//            //TEST: what is our host's address
//            System.out.println("Host address: " + address); 
            
            if(personBeingFollowed.checkStatus() == true) {
                            
                    //create a socket connection
                    Socket sock = new Socket(host, 2008); 
//                    //TEST: did the socket actually connect
//                    System.out.println("Notification socket connected to: " + sock.getInetAddress()); 
//                    System.out.println("Notification socket bound to: " + sock.getLocalAddress()); 
//
                    //create the IO stream
                    Scanner in = new Scanner(sock.getInputStream()); 
                    PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 

                    //do stuff as a protocol
                    out.println(FOLLOW); 

                    //get confirmation back
                    String conf = in.nextLine(); 
//
//                    //TEST: was conf "OKAY"
//                    System.out.println("Conf = " + conf); 

                    if(conf.equals(CONF)) {
                        //give user following
                        out.println(name); 
                    }
  
            }
        }
        
        catch (IOException e) {            
            //print error
            System.err.println("IOEXCEPTION in NotificationThread: " + e.getMessage());
        }
    }                     

 }
    

