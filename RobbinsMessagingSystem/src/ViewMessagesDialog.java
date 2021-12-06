import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*;
import java.sql.Timestamp; 

/**
 *
 * @author a-a-robbins
 */
public class ViewMessagesDialog extends JDialog {
    private String user; 
    private String address; 
    
    //constructor
    public ViewMessagesDialog(String username, String address) { 
        user = username; 
        this.address = address; 
        
      //set window title
      setTitle("View Messages"); 
      
      //set list selection model
      lt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
      
      //create container and layout
      Container contentPane = getContentPane(); 
      BoxLayout layout = new BoxLayout(contentPane, BoxLayout.PAGE_AXIS); 
      contentPane.setLayout(layout); 
      
      //add controls to container
      JScrollPane ltPane = new JScrollPane(lt); 
      contentPane.add(ltPane); 
      contentPane.add(unreadButton); 
      contentPane.add(refreshButton); 
      contentPane.add(doneButton); 
      
      //specify listeners
      lt.addMouseListener(new ListMouseListener()); 
      unreadButton.addActionListener(new UnreadListener()); 
      refreshButton.addActionListener(new RefreshListener()); 
      doneButton.addActionListener(new DoneListener()); 
      //addWindowListener(new MyWindowAdapter()); 
    }
    
    //controls
    private DefaultListModel lm = new DefaultListModel(); 
    private JList lt = new JList(lm); 
    
    private JButton unreadButton = new JButton("Unread"); 
    private JButton refreshButton = new JButton("Refresh"); 
    private JButton doneButton = new JButton("Done"); 
    
    //implementing listeners
    private class ListMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() >= 1) {
                int index = lt.getSelectedIndex(); 
                String name = (String)lm.get(index); 
            }
        }
    }
    
    private class UnreadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //connect to server to retrieve messages
            try {
                //clear text area
                lm.removeAllElements();

                //create an array of strings
                String[] array; 

                //create a host
                String host = address; 

                //create a socket connection
                Socket sock = new Socket(host, 2001); 

                //create the IO stream
                Scanner in = new Scanner(sock.getInputStream()); 
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 

                //do stuff as a protocol
                out.println("Unread");
                //pass username - FIXME: server side reveiving
                out.println(user); 
                

                //get confirmation back
                if(in.nextLine().equals("okay"))
                {
                    //get size of array
                   int size = Integer.parseInt(in.nextLine()); 
                   array = new String[size]; 

                    //loop to bring in strings from server arraylist
                    for(int i = 0; i < size; i++) {
                       array[i] = in.nextLine();                   
                    }

                    for(int i = 0; i < ((array.length)); i++) {
                        lm.addElement(array[i]); 
                    }
                }
                
                else{
                     JOptionPane.showMessageDialog(ViewMessagesDialog.this, "something went wrong and we didn't get 'okay' back..."); 
                }
        }
        
         catch (IOException x) {
            
            //print error
            System.err.println("IOEXCEPTION in unreadListener: " + x.getMessage());
        } 
      }
    }
    
    
    private class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//connect to server to retrieve messages
            try {
                //clear text area
                lm.removeAllElements();

                //create an array of strings
                String[] array; 

                //create a host
                String host = address; 

                //create a socket connection
                Socket sock = new Socket(host, 2001); 

                //create the IO stream
                Scanner in = new Scanner(sock.getInputStream()); 
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 

                //do stuff as a protocol
                out.println("Refresh");
                //pass username - FIXME: server side reveiving
                out.println(user); 
                

                //get confirmation back
                if(in.nextLine().equals("okay"))
                {
                    //get size of array
                   int size = Integer.parseInt(in.nextLine()); 
                   array = new String[size]; 

                    //loop to bring in strings from server arraylist
                    for(int i = 0; i < size; i++) {
                       array[i] = in.nextLine();                   
                    }

                    for(int i = 0; i < ((array.length)); i++) {
                        lm.addElement(array[i]); 
                    }
                }
                
                else{
                     JOptionPane.showMessageDialog(ViewMessagesDialog.this, "something went wrong and we didn't get 'okay' back..."); 
                }
        }
        
         catch (IOException x) {
            
            //print error
            System.err.println("IOEXCEPTION in RefreshListener: " + x.getMessage());
        } 
      }
    }
    
    public class DoneListener implements ActionListener {

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); 
        }
    }
    

    
    
}
