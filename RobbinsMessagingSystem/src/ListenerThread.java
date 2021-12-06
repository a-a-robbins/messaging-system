
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author a-a-robbins
 */
public class ListenerThread implements Runnable {
        JDialog notification; 
    public ListenerThread(JDialog dialog) {
       notification = dialog; 
       notification.setVisible(true); 
    }

    public void run() {
            try {
                //should this be a ServerSocket??
                ServerSocket listen = new ServerSocket(2008);
                
                //display the port# we are listening on
                System.out.println("Listening on port: " + listen.getLocalPort()); 
                
                //display address we are listening on
                System.out.println("Listening on address: " + InetAddress.getLocalHost()); 
                
                while(true) {
                
                //wait for a client to connect
                Socket client = listen.accept(); 
                
                //get IO stream
                PrintWriter out = new PrintWriter(client.getOutputStream(), true); 
                Scanner in = new Scanner(client.getInputStream()); 
                
                //create a protocol
                String protocol = in.nextLine(); 
                //TEST: what protocol did we recieve
                System.out.println("PROTOCOL: " + protocol); 
                out.println("OKAY"); 
                
                //start switch statements and use CONSTANTS declared for the string
                switch(protocol) {
                    case "FOLLOW" :
                       
                        String follower = in.nextLine(); 
                        //TEST: who did we get as the follower
                        System.out.println("Follower is: " + follower); 
                        
                        //JOptionPane.showMessageDialog(notification, follower + " has followed you" );
      
//                        NotificationDialog dialog = new NotificationDialog(new javax.swing.JFrame(), true);
//                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                            @Override
//                            public void windowClosing(java.awt.event.WindowEvent e) {
//                                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
//                            }
//                        });
//                        dialog.setVisible(true);

                        //TEST: without using dialog are we rec'ing the input
                        System.out.println(follower + " has followed you"); 
                       
                        break;
                    
                    case "PRIVATE": 
                        String hashtag = in.nextLine(); 
                        String message = in.nextLine(); 
                        
                        JOptionPane.showMessageDialog(notification, "You have a new private message: \n  hashtag: " + hashtag + ",   message: " + message);
                        break; 
                
                 } 
               

            }
            }
         catch (IOException e) {
                System.err.print("IOException: " + e.getMessage());
            }

    }
}
