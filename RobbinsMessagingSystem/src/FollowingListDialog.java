
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.DefaultListModel;
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
public class FollowingListDialog extends javax.swing.JDialog {
        
        //keywords for server
         private static final String FOLLOW = "Follow"; 
         private static final String UNFOLLOW = "Unfollow"; 
         private static final String DISPLAY = "Display"; 
         private DefaultListModel lm; 


        //create a user to store info that gets passed 
         private GUIUser user = new GUIUser(""); // ?? how can I get around needing to do this ??




    /**
     * Creates new form FollowingListDialog
     */
    public FollowingListDialog(java.awt.Frame parent, boolean modal, GUIUser gu) {
        super(parent, modal);
        
         lm = new DefaultListModel(); 

        initComponents();
        
        
        followList.setModel(lm);
        
        
        //pass user into an accessible variable
        this.user = gu; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        followBtn = new javax.swing.JButton();
        searchFld = new javax.swing.JTextField();
        unfollowBtn = new javax.swing.JButton();
        peopleImFollowingBtn = new javax.swing.JButton();
        peopleFollowingMeBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        followList = new javax.swing.JList<>();
        titleLbl = new javax.swing.JLabel();
        doneBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        followBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        followBtn.setText("Follow");
        followBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followBtnActionPerformed(evt);
            }
        });

        searchFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchFld.setText("<enter username>");
        searchFld.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFldActionPerformed(evt);
            }
        });

        unfollowBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unfollowBtn.setText("Unfollow");
        unfollowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unfollowBtnActionPerformed(evt);
            }
        });

        peopleImFollowingBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        peopleImFollowingBtn.setText("<html>See People I'm <br>Following</html>");
        peopleImFollowingBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        peopleImFollowingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleImFollowingBtnActionPerformed(evt);
            }
        });

        peopleFollowingMeBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        peopleFollowingMeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        peopleFollowingMeBtn.setLabel("<html>See People <br>Following Me</html>");
        peopleFollowingMeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleFollowingMeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unfollowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(peopleImFollowingBtn)
                            .addComponent(followBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(peopleFollowingMeBtn))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(followBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unfollowBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(peopleImFollowingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(peopleFollowingMeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listLbl.setText("<list>");

        jScrollPane1.setViewportView(followList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(listLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listLbl)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Friends Actions");

        doneBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doneBtn.setText("Done");
        doneBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(doneBtn)
                        .addGap(203, 203, 203))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doneBtn)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void followBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followBtnActionPerformed
        try {
            //create a host
            String host = "localhost"; 
            
            //create a socket connection
            Socket sock = new Socket(host, 2001); 
            
            //create the IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
            
            //do stuff as a protocol
            out.println(FOLLOW); 
            out.println(user.getName());
            out.println(searchFld.getText()); 

            
            //get confirmation back
            if(in.nextLine().equals("okay"))
            {
                String result = in.nextLine(); 
                
                //message dialog to inform user of result
                if(result.equals(searchFld.getText())) {
                    JOptionPane.showMessageDialog(FollowingListDialog.this, result + " added to list of people you are following"); 
                }
                else { 
                    JOptionPane.showMessageDialog(FollowingListDialog.this, result);
                }
        
            }
            
            else {
                System.out.print(in.nextLine());
            }
  
        }
        
        catch (IOException e) {            
            //print error
            System.err.println("IOEXCEPTION" + e.getMessage());
        }
    }//GEN-LAST:event_followBtnActionPerformed

    private void unfollowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unfollowBtnActionPerformed
         try {
            //create a host
            String host = "localhost"; 
            
            //create a socket connection
            Socket sock = new Socket(host, 2001); 
            
            //create the IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
            
            //do stuff as a protocol
            out.println(UNFOLLOW); 
            out.println(user.getName());
            out.println(searchFld.getText()); 

            
            //get confirmation back
            if(in.nextLine().equals("okay"))
            {
                String result = in.nextLine(); 
                                
                //message dialog to inform user of result
                if(result.equals(searchFld.getText())) {
                   JOptionPane.showMessageDialog(FollowingListDialog.this, result + " removed from list of people you are following"); 
                }
                else { 
                    JOptionPane.showMessageDialog(FollowingListDialog.this, result); 
                }
           
            }
            
            else {
                System.out.print(in.nextLine());
            }
  
        }
        
        catch (IOException e) {            
            //print error
            System.err.println("IOEXCEPTION" + e.getMessage());
        }
                                            

    }//GEN-LAST:event_unfollowBtnActionPerformed

    private void peopleImFollowingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleImFollowingBtnActionPerformed
try {
            //clear text area
            lm.removeAllElements(); 
            //create an array of strings
            String[] array; 
                       
            //create a host
            String host = "localhost"; 
            
            //create a socket connection
            Socket sock = new Socket(host, 2001); 
            
            //create the IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
            
            //do stuff as a protocol
            out.println(DISPLAY); 
            out.println(user.getName()); 
            out.println("peopleIAmFollowing");
            
            listLbl.setText("People I Am Following");
            
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
                
                //listTextArea.setText(array[0]);
                
                for(int i = 0; i < ((array.length)); i++) {
                    lm.addElement(array[i]); 
                }
                
            }
            
            else {
                System.out.print(in.nextLine());
            }
    
        }
        
        catch (IOException e) {
            
            //print error
            System.err.println("IOEXCEPTION" + e.getMessage());
        }    }//GEN-LAST:event_peopleImFollowingBtnActionPerformed

    private void peopleFollowingMeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleFollowingMeBtnActionPerformed
        try {
            //clear text area
            lm.removeAllElements();
            
            //create an array of strings
            String[] array; 
                       
            //create a host
            String host = "localhost"; 
            
            //create a socket connection
            Socket sock = new Socket(host, 2001); 
            
            //create the IO stream
            Scanner in = new Scanner(sock.getInputStream()); 
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
            
            //do stuff as a protocol
            out.println(DISPLAY); 
            out.println(user.getName()); 
            out.println("peopleFollowingMe");
            
            listLbl.setText("People Following Me");
            
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
        }
        
         catch (IOException e) {
            
            //print error
            System.err.println("IOEXCEPTION" + e.getMessage());
        }                
    }//GEN-LAST:event_peopleFollowingMeBtnActionPerformed

    private void searchFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFldActionPerformed
    }//GEN-LAST:event_searchFldActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_doneBtnActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneBtn;
    private javax.swing.JButton followBtn;
    private javax.swing.JList<String> followList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listLbl;
    private javax.swing.JButton peopleFollowingMeBtn;
    private javax.swing.JButton peopleImFollowingBtn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JButton unfollowBtn;
    // End of variables declaration//GEN-END:variables
}
