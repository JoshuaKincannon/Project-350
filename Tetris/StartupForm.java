package tetris;

import javax.swing.*;

/**
 * GUI for the main menu.
 * This contains buttons to start game, quit and return to leaderboard.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class StartupForm extends javax.swing.JFrame {

    LeaderboardForm showLeaderboard;

    GameForm showGameForm;

    /**
     * Initiates buttons.
     */
    public StartupForm() {
        super();
        initComponents();
    }

    /**
     * This initializes components of the StartupForm.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLeaderboard = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnStartGame = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);


        btnLeaderboard.setText("Leaderboard");
        btnLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderboardActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnStartGame.setText("Start Game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnStartGameActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/oldTetris.PNG"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * Button responsible for accessing the leaderboard.
     * @param evt Action event.
     */
    public void btnLeaderboardActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnLeaderboardActionPerformed
        showLeaderboard  = new LeaderboardForm();
        this.setVisible(false);
        Tetris.showLeaderBoard();
    } //GEN-LAST:event_btnLeaderboardActionPerformed

    /**
     * Button responsible for quitting the game.
     * @param evt Action event.
     */

    public void btnQuitActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnQuitActionPerformed
        System.exit(0);
    } //GEN-LAST:event_btnQuitActionPerformed

    /**
     * Button responsible for starting the game.
     * @param evt Action event.
     */
    public void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnStartGameActionPerformed
        showGameForm = new GameForm();
        this.setVisible(false);
        Tetris.start();
    } //GEN-LAST:event_btnStartGameActionPerformed


    public JButton getBtnLeaderboard() {
        return btnLeaderboard;
    }

    public JButton getBtnQuit() {
        return btnQuit;
    }

    public JButton getBtnStartGame() {
        return btnStartGame;
    }

    public boolean isStartUpVis(){
       return jLabel2.isVisible();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * public variable to access the leaderboard.
     */
    public javax.swing.JButton btnLeaderboard;

    /**
     * public variable to access the quit button.
     */
    public javax.swing.JButton btnQuit;

    /**
     * public variable to access the start game button.
     */
    public javax.swing.JButton btnStartGame;

    /**
     * public variable to access the jLabel.
     */
    public javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
