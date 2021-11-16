import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author a-a-robbins
 */
public class ViewMessagesDialog extends JDialog {
    
    //constructor
    public ViewMessagesDialog() {    
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
      contentPane.add(allButton); 
      contentPane.add(refreshButton); 
      contentPane.add(doneButton); 
      
      //specify listeners
      lt.addMouseListener(new ListMouseListener()); 
      unreadButton.addActionListener(new AddListener()); 
      allButton.addActionListener(new AllListener()); 
      refreshButton.addActionListener(new RefreshListener()); 
      doneButton.addActionListener(new DoneListener()); 
      //addWindowListener(new MyWindowAdapter()); 
    }
    
    //controls
    private DefaultListModel lm = new DefaultListModel(); 
    private JList lt = new JList(lm); 
    
    private JButton unreadButton = new JButton("Unread"); 
    private JButton allButton = new JButton("See All"); 
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
    
    private class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //do stuff
        }
    }
    
    private class AllListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //do stuff
        }
    }
    
    private class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //do stuff
        }
    }
    
    public class DoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    

    
    
}
