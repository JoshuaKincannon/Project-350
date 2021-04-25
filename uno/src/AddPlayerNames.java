import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 *Creates the AddPlayerNames panel where adds 2 to  4 players before starting the game
 * @author Jhoseph
 */
public class AddPlayerNames extends javax.swing.JFrame {

    GameStage gameStage;

    public ArrayList<String> playerIds;
    /**
     * Constructor that creates new form AddPlayerNames
     */
    public AddPlayerNames() {
        initComponents();
        playerIds = new ArrayList<>();
    }
    
    /**
     * Returns player ids.
     * @return ids
     */
    public String[] getPids() {
        String[] pids = playerIds.toArray(new String[playerIds.size()]);
        return pids;
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
        saveButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        pidTextBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pidOneLabel = new javax.swing.JLabel();
        pidTwoLabel = new javax.swing.JLabel();
        pidThreeLabel = new javax.swing.JLabel();
        pidFourLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(650, 302));

        saveButton.setText("SAVE");
        saveButton.setPreferredSize(new java.awt.Dimension(90, 48));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        doneButton.setText("DONE");
        doneButton.setPreferredSize(new java.awt.Dimension(90, 48));
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        pidTextBox.setPreferredSize(new java.awt.Dimension(267, 29));
        pidTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidTextBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Add the names of the players:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Name of the player:");

        pidOneLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        pidTwoLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        pidThreeLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        pidFourLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(pidOneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(pidTwoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pidThreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(pidFourLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pidTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(pidTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pidOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pidThreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pidTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pidFourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pidTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidTextBoxActionPerformed

    /**
     * Prompts the user for a name, and saves them
     * @param evt 
     */
    public void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(pidTextBox.getText().isEmpty()) {
            JLabel message = new JLabel("Please enter in a name!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        //Get what the player wrote
        else {
            String name = pidTextBox.getText().trim();
            playerIds.add(name);
            
            if(playerIds.size() == 1) {
                pidOneLabel.setText(playerIds.get(0));
            }
            else if(playerIds.size() == 2) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
            }
            else if(playerIds.size() == 3) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
                pidThreeLabel.setText(playerIds.get(2));
            }
            else if(playerIds.size() == 4) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
                pidThreeLabel.setText(playerIds.get(2));
                pidFourLabel.setText(playerIds.get(3));
            }
            if(playerIds.size() > 0 && playerIds.size() < 5) {
                JLabel message = new JLabel("Successful Save!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }
            //For four players set it to 5. If 8 players, set it to 9
            if(playerIds.size() == 5) {
                playerIds.remove(name);
                JLabel message = new JLabel("There can only be between 2-4 players!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Checks if the correct number players exists to start the game
     * @param evt 
     */
    public void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        if(playerIds.size() == 1 || playerIds.size() == 0) {
            JLabel message = new JLabel("There must be at least 2 players!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            pidTextBox.setText("");
        }
        else {
            this.dispose();
            gameStage = new GameStage(playerIds);
            gameStage.setVisible(true);
        }
    }//GEN-LAST:event_doneButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayerNames().setVisible(true);
            }
        });
    }

    /**
     * Setter method for playerIds
     * @param playerIds
     */
    public void setPlayerIds(ArrayList<String> playerIds) {
        this.playerIds = playerIds;
    }

    /**
     * Method to check is Panel is showing
     * @return jPanel1.isShowing()
     */
    public boolean isShowingPanel() {
        return jPanel1.isShowing();
    }

    /**
     * Getter method for playerIds
     * @return playerIds
     */
    public ArrayList<String> getPlayerIds() {
        return playerIds;
    }

    /**
     * Getter method for doneButton
     * @return doneButton
     */
    public JButton getDoneButton() {
        return doneButton;
    }

    /**
     * Getter method for saveButton
     * @return saveButton
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton doneButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pidFourLabel;
    private javax.swing.JLabel pidOneLabel;
    private javax.swing.JTextField pidTextBox;
    private javax.swing.JLabel pidThreeLabel;
    private javax.swing.JLabel pidTwoLabel;
    public javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
