package tetris;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class GameForm extends JFrame {
    
    
    private GameArea ga;
    private GameThread gt;
    private NextBlock nb;
    

    /**
     * Creating the gam area space with a width of 10 cell sizes
     */
    public GameForm() {
    
        initComponents();
        
        ga = new GameArea(gameAreaPlaceholder, 10);
        this.add(ga);

        nb = new NextBlock(NextPiece, 6, ga);
        this.add(nb);
        
        nb = new NextBlock(HoldBlock, 6, ga);
        this.add(nb);
        
        intControls();
        
//        Pause.setVisible(false);

    }

    /**
     * initializing the controls of the game
     */
    //adding controls to move tetris pieces 
    private void intControls() {
        
        InputMap im = this.getRootPane().getInputMap(); 
        ActionMap am = this.getRootPane().getActionMap();
    
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("SPACE"), "space");
//        im.put(KeyStroke.getKeyStroke("ENTER"), "esc");


        
      
        am.put("right", new AbstractAction(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockRight();
            }
        }); 

        am.put("left", new AbstractAction(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 ga.moveBlockLeft();
                
            }
               
        });  
        am.put("up", new AbstractAction(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.rotate();
            }
               
        });  
        
        am.put("down", new AbstractAction(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  ga.drop();
                
            }
               
        }); 
        
        am.put("space", new AbstractAction(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  ga.hold();
                
            }
               
        });
        
//       am.put("esc", new AbstractAction(){
//            
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                  ga.pause();
//                
//            }
//               
//        });
    
        
        
        
    }

    /**
     * starting the game
     */
    //this method is responsible for creating a game thread object
    public void startGame(){ 
       ga.initBackGroundArray();
       gt = new GameThread(ga, this);
       ga.holdBlock = null; 
       gt.start();
    }

    /**
     * Updating the display of the score
     * @param score
     */
    public void updateScore(int score) {
        
        scoreDisplay.setText("Score: " + score);
        
        
    }
    
    
    /**
     * updating the dsiplay of the level
     * @param level
     */
    public void updateLevel(int level) {

        levelDisplay.setText("Level: " + level);
        
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Creating the button to return to the main menu
     * @param evt
     */
    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
      
        gt.interrupt();
        this.setVisible(false);
        Tetris.showStartup();
        Tetris.stopSong();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    
    public javax.swing.JPanel getHoldBlock() { 
        return HoldBlock;
    }
    
    
     public javax.swing.JPanel getNextPiece() { 
        return NextPiece;
    }
    
     
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoldBlock;
    private javax.swing.JPanel NextPiece;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JPanel gameAreaPlaceholder;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}
