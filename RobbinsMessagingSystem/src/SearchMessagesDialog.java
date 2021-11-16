import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author a-a-robbins
 */
public class SearchMessagesDialog extends JDialog {
    
    //constructor
    public SearchMessagesDialog() {
        //set window title
        setTitle("Search Messages");
                
        //set list selection model
        lt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        //container and layout
        Container contentPane = getContentPane(); 
        FlowLayout layout = new FlowLayout(); 
        contentPane.setLayout(layout); 
        
        //adding controls to container
        JScrollPane ltPane = new JScrollPane(); 
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
            //do stuff
        }
    }
    
    private class DoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //do stuff
        }
    }
}
