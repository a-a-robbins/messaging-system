/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthreads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author DanAsh4Ever
 */
public class TestThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
                String userAddress = "localhost"; 
                Socket threadSocket = new Socket(userAddress, 2008); 
                //TEST: did our socket actually create
                System.out.println("threadSocket connected to: " + threadSocket.getInetAddress());
                System.out.println("threadSocket bound to: " + threadSocket.getLocalAddress()); 
                
                Scanner threadIn = new Scanner(threadSocket.getInputStream()); 
                PrintWriter threadOut = new PrintWriter(threadSocket.getOutputStream()); 
                //TEST: did our scanner/printwriter create
                System.out.println("Scanner address: " + threadIn); 
                System.out.println("Printwriter address: " + threadOut); 
                
                String protocol = "PRIVATE"; 
                threadOut.println(protocol);
                //TEST: did our protocol send
                System.out.println("threadOut sent: " + protocol); 
                String conf = threadIn.nextLine(); 
                //TEST: what was our conf
                System.out.println("Conf = " + conf);
                
                    if (conf.equals("OKAY")) {
                        threadOut.println("test");
                        threadOut.println("message test"); 
                    }                      

                    else {
                        System.out.println("Something went wrong in getting our confirmation back"); 
                     }

        }
        

        catch(IOException e) {
            //generate error message, perhaps write to log later
            System.err.println("IOEXCEPTION in sendButton1Action: " + e.getMessage());
        }
    }                                           
}
    
    

