
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author a-a-robbins
 */

//create a dialog for users to send public messages
public class SendMessageDialog extends javax.swing.JDialog {

   private String sender; 
   private String address; 
   private GUIUser gu; 
   private static final String SEND = "SEND"; 
   private static final String CONF = "OKAY"; 
   
    public SendMessageDialog(java.awt.Frame parent, boolean modal, String username, String address, GUIUser gu) {
        super(parent, modal);
        this.sender = username; 
        this.address = address; 
        this.gu = gu; 

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        createMessageDialogLabel = new javax.swing.JLabel();
        sendingInfoPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        hashtagField = new javax.swing.JTextField();
        messageField = new javax.swing.JTextField();
        messageLbl = new javax.swing.JLabel();
        sendButtonPanel = new javax.swing.JPanel();
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createMessageDialogLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createMessageDialogLabel.setText("Create Message");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(createMessageDialogLabel)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createMessageDialogLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLabel.setText("#");

        hashtagField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        messageField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        messageLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageLbl.setText("Message: ");

        javax.swing.GroupLayout sendingInfoPanelLayout = new javax.swing.GroupLayout(sendingInfoPanel);
        sendingInfoPanel.setLayout(sendingInfoPanelLayout);
        sendingInfoPanelLayout.setHorizontalGroup(
            sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendingInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(messageLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hashtagField, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(messageField))
                .addContainerGap())
        );
        sendingInfoPanelLayout.setVerticalGroup(
            sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendingInfoPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(hashtagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(sendingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageLbl))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sendButtonPanelLayout = new javax.swing.GroupLayout(sendButtonPanel);
        sendButtonPanel.setLayout(sendButtonPanelLayout);
        sendButtonPanelLayout.setHorizontalGroup(
            sendButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(115, 115, 115))
        );
        sendButtonPanelLayout.setVerticalGroup(
            sendButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(cancelButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendingInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendingInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //dispose of dialog when user is finished
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
          this.dispose(); 
            
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
            try { 
            //create a host
            String host = address; 

            //connect to specified host on Server port#
            Socket sock = new Socket(host, 2001); 
            
            //create IO stream from socket
            Scanner in = new Scanner(sock.getInputStream());            
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);             
                    
            //create protocol
            out.println(SEND);
            out.println(sender); 
            out.println(hashtagField.getText()); 
            out.println(messageField.getText()); 
            
            //store message locally
            gu.addMessage("Hashtag: " + hashtagField.getText() + " Message: " + messageField.getText());
                
            //check for response from server
            String conf = in.nextLine(); 
            if(conf.equals(CONF)) {
               String result = in.nextLine(); 
               JOptionPane.showMessageDialog(SendMessageDialog.this, result); 
           
                //reset text fields after message sent
                hashtagField.setText("");
                messageField.setText(""); 
            }
            
            else { 
                JOptionPane.showMessageDialog(SendMessageDialog.this, "Something went wrong in the send function");
            }  
         }
       
       catch (IOException e) {
           System.err.println("IOEXCEPTION in sendMessageAction: " + e.getMessage());
       }
    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel createMessageDialogLabel;
    private javax.swing.JTextField hashtagField;
    private javax.swing.JTextField messageField;
    private javax.swing.JLabel messageLbl;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel sendButtonPanel;
    private javax.swing.JPanel sendingInfoPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
