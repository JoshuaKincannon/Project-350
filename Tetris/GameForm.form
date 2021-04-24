package tetris;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Creates the GUI for the game screen and initializes game controls.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class GameForm extends JFrame {

    private GameArea ga;
    private GameThread gt;
    private NextBlock nb;

    StartupForm backToStart;
    GameThread thread;
    GameForm form;

    /**
     * Creates new GameArea and Next Block objects.
     * Passes necessary parameters to instantiate GameArea, NextBlock, and HoldBlock.
     */
    public GameForm() {
        super();
        initComponents();

        ga = new GameArea(gameAreaPlaceholder, 10);
        this.add(ga);

        nb = new NextBlock(NextPiece, 6, ga);
        this.add(nb);

        nb = new NextBlock(HoldBlock, 6, ga);
        this.add(nb);

        intControls();
    }

    /**
     *  Getter method to access the JPanel.
     * @return gameAreaPlaceholder which is a JPanel
     */
    public JPanel getJPanel() {
        return gameAreaPlaceholder;
    }

    /**
     * Initializes the controls of the game.
     */
    private void intControls() {

        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("SPACE"), "space");
//        im.put(KeyStroke.getKeyStroke("ENTER"), "esc");

        am.put("right", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockRight();
            }
        });

        am.put("left", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockLeft();
            }
        });

        am.put("up", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ga.rotate();
            }
        });

        am.put("down", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ga.drop();
            }
        });

        am.put("space", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ga.hold();
            }
        });
    }

    /**
     * Starts the game.
     * Creates a new GameThread object and calls the initBackGroundArray method from GameArea.
     * This also sets the holdBlock to null after leaving the game screen.
     */
    public void startGame() {
        ga.initBackGroundArray();
        gt = new GameThread(ga, this);
        ga.holdBlock = null;
        gt.start();
    }

    /**
     * Updates the display of the score.
     * @param score Current score of the game.
     */
    public void updateScore(int score) {

        scoreDisplay.setText("Score: " + score);


    }

    /**
     * Updates the display of the level.
     * @param level Current level of the game.
     */
    public void updateLevel(int level) {

        levelDisplay.setText("Level: " + level);

    }

    /**
     *
     * @return
     */
    public boolean isGameFormVis() {
        return gameAreaPlaceholder.isVisible();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameAreaPlaceholder = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        levelDisplay = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        NextPiece = new javax.swing.JPanel();
        HoldBlock = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setResizable(false);

        gameAreaPlaceholder.setBackground(new java.awt.Color(0, 102, 102));
        gameAreaPlaceholder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gameAreaPlaceholder.setPreferredSize(new java.awt.Dimension(310, 560));

        javax.swing.GroupLayout gameAreaPlaceholderLayout = new javax.swing.GroupLayout(gameAreaPlaceholder);
        gameAreaPlaceholder.setLayout(gameAreaPlaceholderLayout);
        gameAreaPlaceholderLayout.setHorizontalGroup(
                gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 304, Short.MAX_VALUE)
        );
        gameAreaPlaceholderLayout.setVerticalGroup(
                gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 554, Short.MAX_VALUE)
        );

        scoreDisplay.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        scoreDisplay.setText("Score: 0");
        scoreDisplay.setToolTipText("");
        scoreDisplay.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(102, 102, 102)));
        scoreDisplay.setName(""); // NOI18N

        levelDisplay.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        levelDisplay.setText("Level: 1");
        levelDisplay.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(102, 102, 102)));
        levelDisplay.setName(""); // NOI18N

        btnMainMenu.setText("Main Menu");
        btnMainMenu.setFocusable(false);
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        NextPiece.setBackground(new java.awt.Color(51, 51, 51));
        NextPiece.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NEXT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        NextPiece.setName("NextPiece"); // NOI18N
        NextPiece.setPreferredSize(new java.awt.Dimension(190, 190));

        javax.swing.GroupLayout NextPieceLayout = new javax.swing.GroupLayout(NextPiece);
        NextPiece.setLayout(NextPieceLayout);
        NextPieceLayout.setHorizontalGroup(
                NextPieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        NextPieceLayout.setVerticalGroup(
                NextPieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 163, Short.MAX_VALUE)
        );

        HoldBlock.setBackground(new java.awt.Color(51, 51, 51));
        HoldBlock.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOLD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        HoldBlock.setName("HoldBlock"); // NOI18N
        HoldBlock.setPreferredSize(new java.awt.Dimension(190, 190));

        javax.swing.GroupLayout HoldBlockLayout = new javax.swing.GroupLayout(HoldBlock);
        HoldBlock.setLayout(HoldBlockLayout);
        HoldBlockLayout.setHorizontalGroup(
                HoldBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        HoldBlockLayout.setVerticalGroup(
                HoldBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 163, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(HoldBlock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NextPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(levelDisplay)
                                                .addGap(18, 18, 18)
                                                .addComponent(scoreDisplay)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addComponent(NextPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(HoldBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        NextPiece.getAccessibleContext().setAccessibleName("");
        HoldBlock.getAccessibleContext().setAccessibleName("HoldBlock");

        pack();
        setLocationRelativeTo(null);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * Button to navigate to the main menu.
     * @param evt Action event.
     */
    public void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnMainMenuActionPerformed
        backToStart = new StartupForm();
        form = new GameForm();
        gt = new GameThread(ga,form);
        gt.interrupt();
        this.setVisible(false);
        Tetris.showStartup();
        Tetris.stopSong();
    } //GEN-LAST:event_btnMainMenuActionPerformed

    public JButton getBtnMainMenu() {
        return btnMainMenu;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoldBlock;
    private javax.swing.JPanel NextPiece;
    private javax.swing.JButton btnMainMenu;
    /**
     * gameAreaPlaceHolder to access JPanel for testing.
     */
    public javax.swing.JPanel gameAreaPlaceholder;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}
