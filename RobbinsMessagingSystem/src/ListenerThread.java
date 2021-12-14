
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author a-a-robbins
 */

//create a thread to listen for incoming notifications from other clients and the server
public class ListenerThread implements Runnable {
        private JDialog notification; 
        private static final String FOLLOW = "FOLLOW"; 
        private static final String PRIVATE = "PRIVATE"; 
        private static final String SHUTDOWN = "SHUTDOWN";
        private static final String CONF = "OKAY"; 
    public ListenerThread() {
        notification = new JDialog(); 
        notification.setVisible(true); 
    }

    public void run() {
            try { 
                //create a ServerSocket to listen for incoming connections
                ServerSocket listen = new ServerSocket(2008);
                
                //display the port# we are listening on
                System.out.println("Listening on port: " + listen.getLocalPort()); 
                
                //display address we are listening on
                System.out.println("Listening on address: " + InetAddress.getLocalHost());
                
                Boolean stayAlive = true; 
                
                while(stayAlive == true) {
                
                //wait for a client to connect
                Socket client = listen.accept(); 
//                //TEST: did client create
//                System.out.println("Client waiting and heard: " + client); 
                
                //get IO stream
                PrintWriter out = new PrintWriter(client.getOutputStream(), true); 
                Scanner in = new Scanner(client.getInputStream()); 
//                //TEST: did printwriter and scanner create
//                System.out.println("Printwriter address: " + out); 
//                System.out.println("Scanner address: " + in); 
                
                //TEST: let's send something to the connected 
                //out.println("testing connection of listener to somewhere else"); 
                
                //create a protocol
                String protocol = in.nextLine(); 
//                //TEST: what protocol did we recieve
//                System.out.println("PROTOCOL: " + protocol); 
                out.println(CONF); 
                
                //start switch statements and use CONSTANTS declared for the string
                switch(protocol) {
                    case FOLLOW :
                       
                        String follower = in.nextLine(); 
//                        //TEST: who did we get as the follower
//                        System.out.println("Follower is: " + follower); 
                        
                        JOptionPane.showMessageDialog(notification, follower + " has followed you" );
      

//                        //TEST: without using dialog are we rec'ing the input
//                        System.out.println(follower + " has followed you"); 
                       
                        break;
                    
                    case PRIVATE: 
                        String hashtag = in.nextLine(); 
                        String message = in.nextLine(); 
                                            
                        JOptionPane.showMessageDialog(notification, "You have a new private message: \n  hashtag: " + hashtag + ",   message: " + message);
                        
//                        //TEST: did it work
//                        System.out.println("You have a new private message: \n  hashtag: " + hashtag +  ", message: " + message); 
                        break; 
                        
                    case SHUTDOWN : 
                        stayAlive = false; 
//                        //TEST: did we kill the thread
//                        System.out.println("stayAlive from thread = " + stayAlive); 
                        break; 
                 } 
               

            }
                //close ServerSocket to prevent net_bind
                listen.close(); 
         }
         catch (IOException e) {
                System.err.print("IOException in ListenerThread: " + e.getMessage());
            }

    }
}
