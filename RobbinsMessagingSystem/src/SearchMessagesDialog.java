import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author a-a-robbins
 */

//FIXME (12/3/2021): Nothing coming up when hit GO, also DONE has no functionality
public class SearchMessagesDialog extends JDialog {
    private String address;
    
    //constructor
    public SearchMessagesDialog(String address) {
        this.address = address;
        //set window title
        setTitle("Search Messages");
                
        //set list selection model
        lt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        //container and layout
        Container contentPane = getContentPane(); 
        FlowLayout layout = new FlowLayout(); 
        contentPane.setLayout(layout); 
        
        //adding controls to container
        JScrollPane ltPane = new JScrollPane(lt); 
        contentPane.add(ltPane); 
        contentPane.add(searchLabel); 
        contentPane.add(searchField); 
        contentPane.add(searchButton); 
        contentPane.add(doneButton); 
        
        //specify listeners
        lt.addMouseListener(new ListMouseListener()); 
        searchField.addMouseListener(new TextClickListener());
        searchButton.addActionListener(new SearchListener());
        doneButton.addActionListener(new DoneListener());
    }
    
    
    //controls
    private DefaultListModel lm = new DefaultListModel(); 
    private JList lt = new JList(lm); 
    
    private JTextField searchField = new JTextField("<enter search term here>"); 
    private JLabel searchLabel = new JLabel("Keyword: "); 
    private JButton searchButton = new JButton("Go"); 
    private JButton doneButton = new JButton("Done"); 
    
    
    //listeners
    private class TextClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            searchField.selectAll(); 
        }
    }
    private class ListMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() >= 1) {
                //do stuff
            }
        }
    }
    
    private class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //connect to server to search messages
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
                out.println("Search");
                out.println(searchField.getText()); 
                //pass username - FIXME: server side reveiving
                //out.println(user); 
                

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
                     JOptionPane.showMessageDialog(SearchMessagesDialog.this, "something went wrong and we didn't get 'okay' back..."); 
                }
        }
        
         catch (IOException x) {
            
            //print error
            System.err.println("IOEXCEPTION" + x.getMessage());
        } 
        }
    }
    
    private class DoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //this.dispose();
            //dialog.dispose(); 
        }
    }
}
