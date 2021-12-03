
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
                out.println("OKAY"); 
                
                //start switch statements and use CONSTANTS declared for the string
                switch(protocol) {
                    case "FOLLOW" :
                       if(in.nextLine().equals("OKAY")) {
                        String follower = in.nextLine(); 
                        JOptionPane.showMessageDialog(notification, follower + " has followed you" );
      
//                        NotificationDialog dialog = new NotificationDialog(new javax.swing.JFrame(), true);
//                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                            @Override
//                            public void windowClosing(java.awt.event.WindowEvent e) {
//                                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
//                            }
//                        });
//                        dialog.setVisible(true);

        
                        System.out.println(follower + " has followed you"); 
                       }
                        break; 
                
                 } 
               

            }
            }
         catch (IOException e) {
                System.err.print("IOException: " + e.getMessage());
            }

    }
}
