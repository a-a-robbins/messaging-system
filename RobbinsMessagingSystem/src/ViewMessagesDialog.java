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
import java.util.ArrayList; 

/**
 *
 * @author a-a-robbins
 */

//create a dialog for user to view messages
public class ViewMessagesDialog extends JDialog {
    private String user; 
    private String address; 
    private GUIUser gu; 
    private static final String UNREAD = "UNREAD"; 
    private static final String REFRESH = "REFRESH"; 
    private static final String CONF = "OKAY"; 
    
    public ViewMessagesDialog(String username, String address, GUIUser gu) { 
        user = username; 
        this.address = address; 
        this.gu = gu; 
        
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
      contentPane.add(sentButton); 
      contentPane.add(doneButton); 
      
      //specify listeners
      lt.addMouseListener(new ListMouseListener()); 
      unreadButton.addActionListener(new UnreadListener()); 
      refreshButton.addActionListener(new RefreshListener());
      sentButton.addActionListener(new SentListener()); 
      doneButton.addActionListener(new DoneListener()); 
      //addWindowListener(new MyWindowAdapter()); 
    }
    
    //controls
    private DefaultListModel lm = new DefaultListModel(); 
    private JList lt = new JList(lm); 
    
    private JButton unreadButton = new JButton("Unread"); 
    private JButton refreshButton = new JButton("Refresh"); 
    private JButton sentButton = new JButton("Sent"); 
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
    
    //connect to server and return all unread messages
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
                out.println(UNREAD);
                //pass username - FIXME: server side reveiving
                out.println(user); 
                

                //get confirmation back
                String conf = in.nextLine(); 
                if(conf.equals(CONF))
                {
                    //get size of array
                   int size = Integer.parseInt(in.nextLine()); 
                   array = new String[size]; 

                    //loop to bring in strings from server arraylist
                    for(int i = 0; i < size; i++) {
                       array[i] = in.nextLine();                   
                    }

                    //add strings to list
                    for(int i = 0; i < ((array.length)); i++) {
                        lm.addElement(array[i]); 
                    }
                    
                    if(size == 0) {
                        JOptionPane.showMessageDialog(ViewMessagesDialog.this, "You have no messages"); 
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
    
    //connect to server to get all messages sent between last
    //unread action event and current LocalDate
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
                out.println(REFRESH);
                //pass username - FIXME: server side receiving
                out.println(user);                 

                //get confirmation back
                String conf = in.nextLine(); 
                if(conf.equals(CONF))
                {
                    //get size of array
                   int size = Integer.parseInt(in.nextLine()); 
                   array = new String[size]; 

                    //loop to bring in strings from server arraylist
                    for(int i = 0; i < size; i++) {
                       array[i] = in.nextLine();                   
                    }

                    //add strings to list
                    for(int i = 0; i < ((array.length)); i++) {
                        lm.addElement(array[i]); 
                    }
                    
                    if(size == 0) {
                        JOptionPane.showMessageDialog(ViewMessagesDialog.this, "You have no messages"); 
                    }
                }
                
                else{
                     JOptionPane.showMessageDialog(ViewMessagesDialog.this, "something went wrong and we didn't get 'okay' back..."); 
                }
        }
        
         catch (IOException x) {
             System.err.println("IOEXCEPTION in RefreshListener: " + x.getMessage());
        } 
      }
    }
    
    //access GUIUser kept locally to get all messages sent during current session
    private class SentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            ArrayList<String> list = gu.getMessages();
            if(list.size() == 0) {
                JOptionPane.showMessageDialog(ViewMessagesDialog.this, "You haven't sent any messages this session");
            }
            else {
                for(int i = 0; i < list.size(); i++) {
                lm.addElement(list.get(i));
                }
            }
            
        }
     }
    
    //dispose of dialog when user finished
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
