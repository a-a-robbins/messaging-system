
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanAsh4Ever
 */
public class PrivateMessageDialog extends javax.swing.JDialog {
    private String serverAddress; 

    /**
     * Creates new form PrivateMessageDialog
     */
    public PrivateMessageDialog(java.awt.Frame parent, boolean modal, String address) {
        super(parent, modal);
        initComponents();
        serverAddress = address;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        privateMessageDialogLabel = new javax.swing.JLabel();
        sendingInfoPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        hashtagField = new javax.swing.JTextField();
        messageField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        toField = new javax.swing.JTextField();
        toLabel = new javax.swing.JLabel();
        sendButtonPanel1 = new javax.swing.JPanel();
        sendButton1 = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        privateMessageDialogLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        privateMessageDialogLabel.setText("Private Message");

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLabel.setText("#");

        hashtagField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        messageField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageLabel.setText("Message: ");

        toField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        toLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toLabel.setText("To:");

        javax.swing.GroupLayout sendingInfoPanelLayout = new javax.swing.GroupLayout(sendingInfoPanel);
        sendingInfoPanel.setLayout(sendingInfoPanelLayout);
        sendingInfoPanelLayout.setHorizontalGroup(
            sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendingInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
                        .addComponent(toLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toField)
                    .addComponent(hashtagField, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(messageField))
                .addContainerGap())
        );
        sendingInfoPanelLayout.setVerticalGroup(
            sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendingInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel))
                .addGap(18, 18, 18)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(hashtagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sendButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendButton1.setText("Send");
        sendButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButton1ActionPerformed(evt);
            }
        });

        cancelButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sendButtonPanel1Layout = new javax.swing.GroupLayout(sendButtonPanel1);
        sendButtonPanel1.setLayout(sendButtonPanel1Layout);
        sendButtonPanel1Layout.setHorizontalGroup(
            sendButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendButtonPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton1)
                .addGap(106, 106, 106))
        );
        sendButtonPanel1Layout.setVerticalGroup(
            sendButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendButtonPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton1)
                    .addComponent(cancelButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendingInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendButtonPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(privateMessageDialogLabel)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(privateMessageDialogLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendingInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButtonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButton1ActionPerformed
        try {
            //create a host, localhost = local machine (no need for IP address)
            //talk to server to check if user is online and get their IP address
            String host = serverAddress;
            //TEST: what is the address we are trying to get information from
            System.out.println("Server Address to get our recievee info: " + serverAddress);

            //connect to specified host on Server port#
            Socket sock = new Socket(host, 2001);

            //create IO stream from socket
            Scanner in = new Scanner(sock.getInputStream());
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

            //create protocol
            out.println("Get");
            out.println(toField.getText());
            
            String conf = in.nextLine(); 
            //TEST: what was our conf
            System.out.println("Conf = " + conf); 
     
            
            //check for response from server
            if(conf.equals("okay")) {
                String userAddress = in.nextLine(); 
                //TEST: what address did we get from the server
                System.out.println("Recievee's address from server: " + userAddress); 
                
                 
                
                Socket threadSocket = new Socket(userAddress, 2008); 
                //TEST: did our socket actually create
                System.out.println("threadSocket connected to: " + threadSocket.getInetAddress());
                System.out.println("threadSocket bound to: " + threadSocket.getLocalAddress()); 
                
                Scanner threadIn = new Scanner(threadSocket.getInputStream()); 
                PrintWriter threadOut = new PrintWriter(threadSocket.getOutputStream(), true); 
                //TEST: did our scanner/printwriter create
                System.out.println("Scanner address: " + threadIn); 
                System.out.println("Printwriter address: " + threadOut); 
                
                String protocol = "PRIVATE"; 
                threadOut.println(protocol);
                //TEST: did our protocol send
                System.out.println(protocol); 
                conf = threadIn.nextLine(); 
                //TEST: what was our conf
                System.out.println("Conf = " + conf);
                
                    if (conf.equals("OKAY")) {
                        threadOut.println(hashtagField.getText());
                        threadOut.println(messageField.getText()); 
                    }

                
                //reset text fields after message sent
                toField.setText(""); 
                hashtagField.setText("");
                messageField.setText("");
            }

            else {
                JOptionPane.showMessageDialog(PrivateMessageDialog.this, "Something went wrong in the send function");
            }

        }

        catch (IOException e) {
            //generate error message, perhaps write to log later
            System.err.println("IOEXCEPTION in sendButton1Action: " + e.getMessage());
        }
    }//GEN-LAST:event_sendButton1ActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        this.dispose(); 

    }//GEN-LAST:event_cancelButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField hashtagField;
    private javax.swing.JTextField messageField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel privateMessageDialogLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendButton1;
    private javax.swing.JPanel sendButtonPanel;
    private javax.swing.JPanel sendButtonPanel1;
    private javax.swing.JPanel sendingInfoPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField toField;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
