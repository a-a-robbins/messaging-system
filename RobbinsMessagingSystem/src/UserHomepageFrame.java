
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



/**
 *
 * @author a-a-robbins
 */

//create a frame from which all other dialogs can be generated from
public class UserHomepageFrame extends javax.swing.JFrame { 
        GUIUser gu = new GUIUser(""); 
        private String address = "localhost";   
//        private ListenerThread lt = new ListenerThread(); 
//        private Thread t = new Thread(lt);
        private static final String LOGOFF = "LOGOFF";
        private static final String SHUTDOWN = "SHUTDOWN"; 

     /**
     * Creates new form UserHomepageFrame
     */
    public UserHomepageFrame() {
        initComponents();
        addWindowListener(new Close());
                
        //create new landing page dialog (log in/register)
        UserLandingPage dialog = new UserLandingPage(new javax.swing.JFrame(), true, address);
           
           // in case dialog is exited without completing log in process
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        //TEST: let me know before we exit
////                        System.out.println("ATTENTION: system is exiting"); 
////                         System.exit(0);
//                        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                    }
//                });
            dialog.setVisible(true);
   
            //creating a GUIUser to save important user info
            gu.setName(dialog.getUsername()); 

            //saving username to display on homepage frame & use for logging off method
            usernameLbl.setText(gu.getName()); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        landingPanel = new javax.swing.JPanel();
        viewMessagesLabel = new javax.swing.JLabel();
        CreateMessageLabel = new javax.swing.JLabel();
        searchMessagesLabel = new javax.swing.JLabel();
        friendsLabel = new javax.swing.JLabel();
        privateMessageLabel = new javax.swing.JLabel();
        helloUserLabel2 = new javax.swing.JLabel();
        homepageButtonPanel = new javax.swing.JPanel();
        viewMessagesButton = new javax.swing.JButton();
        createMessageButton = new javax.swing.JButton();
        searchMessagesButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        sendMessageButton = new javax.swing.JButton();
        logOffButtonPanel = new javax.swing.JPanel();
        logOffButton = new javax.swing.JButton();
        helloUserLabel1 = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        viewMessagesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewMessagesLabel.setText("View Messages");

        CreateMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreateMessageLabel.setText("Send Message");

        searchMessagesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchMessagesLabel.setText("Search Messages");

        friendsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendsLabel.setText("See & Find Friends");

        privateMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        privateMessageLabel.setText("Send Private Message");

        javax.swing.GroupLayout landingPanelLayout = new javax.swing.GroupLayout(landingPanel);
        landingPanel.setLayout(landingPanelLayout);
        landingPanelLayout.setHorizontalGroup(
            landingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(landingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(landingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewMessagesLabel)
                    .addComponent(CreateMessageLabel)
                    .addComponent(searchMessagesLabel)
                    .addComponent(friendsLabel)
                    .addComponent(privateMessageLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        landingPanelLayout.setVerticalGroup(
            landingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(landingPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(viewMessagesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateMessageLabel)
                .addGap(18, 18, 18)
                .addComponent(searchMessagesLabel)
                .addGap(31, 31, 31)
                .addComponent(friendsLabel)
                .addGap(18, 18, 18)
                .addComponent(privateMessageLabel)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        helloUserLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        helloUserLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helloUserLabel2.setText(" , this is your homepage!");

        viewMessagesButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewMessagesButton.setText("Go");
        viewMessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMessagesButtonActionPerformed(evt);
            }
        });

        createMessageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createMessageButton.setText("Go");
        createMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMessageButtonActionPerformed(evt);
            }
        });

        searchMessagesButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchMessagesButton.setText("Go");
        searchMessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMessagesButtonActionPerformed(evt);
            }
        });

        friendsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendsButton.setText("Go");
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        sendMessageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendMessageButton.setText("Go");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homepageButtonPanelLayout = new javax.swing.GroupLayout(homepageButtonPanel);
        homepageButtonPanel.setLayout(homepageButtonPanelLayout);
        homepageButtonPanelLayout.setHorizontalGroup(
            homepageButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageButtonPanelLayout.createSequentialGroup()
                .addGroup(homepageButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewMessagesButton)
                    .addComponent(createMessageButton)
                    .addComponent(searchMessagesButton)
                    .addComponent(friendsButton)
                    .addComponent(sendMessageButton))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        homepageButtonPanelLayout.setVerticalGroup(
            homepageButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageButtonPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(viewMessagesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createMessageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchMessagesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(friendsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendMessageButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logOffButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logOffButton.setLabel("Log Off");
        logOffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logOffButtonPanelLayout = new javax.swing.GroupLayout(logOffButtonPanel);
        logOffButtonPanel.setLayout(logOffButtonPanelLayout);
        logOffButtonPanelLayout.setHorizontalGroup(
            logOffButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOffButtonPanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(logOffButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logOffButtonPanelLayout.setVerticalGroup(
            logOffButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOffButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logOffButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        helloUserLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        helloUserLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helloUserLabel1.setText("Hello");

        usernameLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLbl.setText("<username>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(helloUserLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helloUserLabel2)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logOffButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(landingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homepageButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helloUserLabel2)
                    .addComponent(helloUserLabel1)
                    .addComponent(usernameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(landingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(homepageButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logOffButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //create the view messages dialog
    private void viewMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMessagesButtonActionPerformed
        JDialog dialog = new ViewMessagesDialog(gu.getName(), address, gu); 
        dialog.setSize(600, 400); 
        dialog.setVisible(true); 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_viewMessagesButtonActionPerformed

//create a dialog for users to send public messages
    private void createMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMessageButtonActionPerformed
                    
        String username = gu.getName();     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SendMessageDialog dialog = new SendMessageDialog(new javax.swing.JFrame(), true, username, address, gu);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                dialog.setVisible(true);
            }
        }); 
    }//GEN-LAST:event_createMessageButtonActionPerformed

    //contact server to execute log off request
    private void logOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffButtonActionPerformed
        try {
            //create a host
            String host = address; 
            //create a socket connection
            Socket sock = new Socket(host, 2001); 
            //create IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            //do stuff as a protocol
            out.println(LOGOFF);
            out.println(usernameLbl.getText()); 
            JOptionPane.showMessageDialog(UserHomepageFrame.this, in.nextLine()); 
            gu.setStatus(false);
            
            //open a connection on port 2008 to localhost and tell it not to stayalive
            String threadHost = "localhost"; 
            Socket threadSocket = new Socket(threadHost, 2008); 
            PrintWriter threadOut = new PrintWriter(threadSocket.getOutputStream(), true); 
            threadOut.println(SHUTDOWN);
        }
        
        catch(IOException e) {
            System.err.println("IOException: in logOffButtonAction: " + e.getMessage());
         }
        
        //dispose of current homepage frame
        this.dispose(); 
        //TEST: do we make it past dispose statement
//        System.out.println("We have made it past this.dispose()"); 
        //create new homepage frame to circle user back to log in
        UserHomepageFrame frame = new UserHomepageFrame(); 
        //TEST: did we start a new homepage frame
//        System.out.println("We have started a new UserHomepageFrame"); 
        frame.setVisible(true); 
        //TEST: for funsies, did we set visible
//        System.out.println("Is the frame visible? " + frame.isVisible()); 
    }//GEN-LAST:event_logOffButtonActionPerformed

    //create dialog for user to follow/unfollow/see friends
    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
       FollowingListDialog dialog = new FollowingListDialog(new javax.swing.JFrame(), true, gu, address);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                dialog.setVisible(true);

    }//GEN-LAST:event_friendsButtonActionPerformed

    //create dialog for user to search messages by keyword
    private void searchMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMessagesButtonActionPerformed
    /* Create and display the dialog */
        JDialog dialog = new SearchMessagesDialog(address); 
        dialog.setSize(600, 400); 
        dialog.setVisible(true); 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);    }//GEN-LAST:event_searchMessagesButtonActionPerformed

    //create dialog for user to send private messages
    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrivateMessageDialog dialog = new PrivateMessageDialog(new javax.swing.JFrame(), true, address);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    //Log off user at window closing event and reroute to log in dialog
    private class Close extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            try {
                //create a host
                String host = address; 
                //create a socket connection
                Socket sock = new Socket(host, 2001);
                //create IO stream
                Scanner in = new Scanner(sock.getInputStream()); 
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                //do stuff as a protocol
                out.println(LOGOFF);
                out.println(usernameLbl.getText()); 
                JOptionPane.showMessageDialog(UserHomepageFrame.this, in.nextLine()); 
                gu.setStatus(false); 
                
                //open a connection on port 2008 to localhost and tell it not to stayalive
                String threadHost = "localhost"; 
                Socket threadSocket = new Socket(threadHost, 2008); 
                PrintWriter threadOut = new PrintWriter(threadSocket.getOutputStream(), true); 
                threadOut.println(SHUTDOWN);
        }
        
        catch(IOException x) {
            System.err.println("IOException: in logOffButtonAction: " + x.getMessage());
         }
            //dispose of current homepage frame
            UserHomepageFrame.this.dispose();  
            //TEST: did we make it past dispose
//            System.out.println("We are past UserHomepageFrame.this.dispose()"); 
            //generate new homepage frame which redirects to log in dialog
            UserHomepageFrame frame = new UserHomepageFrame();
            //TEST: have we gotten this far
//            System.out.println("About to create new frame"); 
            frame.setVisible(true); 
            //TEST: for funsies, did we set visible
//            System.out.println("Is the frame visible? " + frame.isVisible()); 
        }
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreateMessageLabel;
    private javax.swing.JButton createMessageButton;
    private javax.swing.JButton friendsButton;
    private javax.swing.JLabel friendsLabel;
    private javax.swing.JLabel helloUserLabel1;
    private javax.swing.JLabel helloUserLabel2;
    private javax.swing.JPanel homepageButtonPanel;
    private javax.swing.JPanel landingPanel;
    private javax.swing.JButton logOffButton;
    private javax.swing.JPanel logOffButtonPanel;
    private javax.swing.JLabel privateMessageLabel;
    private javax.swing.JButton searchMessagesButton;
    private javax.swing.JLabel searchMessagesLabel;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JButton viewMessagesButton;
    private javax.swing.JLabel viewMessagesLabel;
    // End of variables declaration//GEN-END:variables
}
                
