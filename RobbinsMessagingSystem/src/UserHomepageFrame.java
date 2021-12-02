
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public class UserHomepageFrame extends javax.swing.JFrame {
        private static final String LOGOFF = "LogOff"; 
        GUIUser gu = new GUIUser(""); 

    /**
     * Creates new form UserHomepageFrame
     */
    public UserHomepageFrame() {
        initComponents();
        
        //create new landing page dialog (log in/register)
        UserLandingPage dialog = new UserLandingPage(new javax.swing.JFrame(), true);
           
            //in case dialog is exited without completing log in process
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
            dialog.setVisible(true);
            
         //start thread
         ListenerThread lt = new ListenerThread(); 
         Thread t = new Thread(lt); 
         t.start(); 
            
            
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
        helloUserLabel2 = new javax.swing.JLabel();
        homepageButtonPanel = new javax.swing.JPanel();
        viewMessagesButton = new javax.swing.JButton();
        createMessageButton = new javax.swing.JButton();
        searchMessagesButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        logOffButtonPanel = new javax.swing.JPanel();
        logOffButton = new javax.swing.JButton();
        helloUserLabel1 = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewMessagesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewMessagesLabel.setText("View Messages");

        CreateMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreateMessageLabel.setText("Send Message");

        searchMessagesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchMessagesLabel.setText("Search Messages");

        friendsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendsLabel.setText("See & Find Friends");

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
                    .addComponent(friendsLabel))
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
                .addGap(18, 18, 18)
                .addComponent(friendsLabel)
                .addContainerGap(27, Short.MAX_VALUE))
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

        javax.swing.GroupLayout homepageButtonPanelLayout = new javax.swing.GroupLayout(homepageButtonPanel);
        homepageButtonPanel.setLayout(homepageButtonPanelLayout);
        homepageButtonPanelLayout.setHorizontalGroup(
            homepageButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageButtonPanelLayout.createSequentialGroup()
                .addGroup(homepageButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewMessagesButton)
                    .addComponent(createMessageButton)
                    .addComponent(searchMessagesButton)
                    .addComponent(friendsButton))
                .addGap(0, 10, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(landingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(homepageButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(logOffButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMessagesButtonActionPerformed
        JDialog dialog = new ViewMessagesDialog(gu.getName()); 
        dialog.setSize(600, 400); 
        dialog.setVisible(true); 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_viewMessagesButtonActionPerformed

    private void createMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMessageButtonActionPerformed
                    
        String username = gu.getName();     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SendMessageDialog dialog = new SendMessageDialog(new javax.swing.JFrame(), true, username);
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

    private void logOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffButtonActionPerformed
        try {
            String host = "localhost"; 
            Socket sock = new Socket(host, 2001); 
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            
            out.println(LOGOFF);
            out.println(usernameLbl.getText()); 
            JOptionPane.showMessageDialog(UserHomepageFrame.this, in.nextLine()); 
            gu.setStatus(false); 
        }
        
        catch(IOException e) {
            System.err.println("IOException");
            System.err.println(e.getMessage());
        }
        
        System.exit(0); 
    }//GEN-LAST:event_logOffButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
       FollowingListDialog dialog = new FollowingListDialog(new javax.swing.JFrame(), true, gu);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                dialog.setVisible(true);

    }//GEN-LAST:event_friendsButtonActionPerformed

    private void searchMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMessagesButtonActionPerformed
 /* Create and display the dialog */
        JDialog dialog = new SearchMessagesDialog(); 
        dialog.setSize(600, 400); 
        dialog.setVisible(true); 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);    }//GEN-LAST:event_searchMessagesButtonActionPerformed

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
    private javax.swing.JButton searchMessagesButton;
    private javax.swing.JLabel searchMessagesLabel;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JButton viewMessagesButton;
    private javax.swing.JLabel viewMessagesLabel;
    // End of variables declaration//GEN-END:variables
}
