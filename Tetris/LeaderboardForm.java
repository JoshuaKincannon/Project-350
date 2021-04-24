package tetris;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Creates the GUI of the leaderboard.
 * Displays and the name and score of players.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class LeaderboardForm extends javax.swing.JFrame {
    /**
     * This variable is the table and is public for testing.
     */
    public static DefaultTableModel tm;
    private String leaderboardFile = "leaderboard";
    private TableRowSorter<TableModel> sorter;

    StartupForm showStartUp;

    /**
     * Initializes the table Components.
     */
    public LeaderboardForm() {
        super();
        initComponents();
        initTableData();
        initTableSorter();
    }

    /**
     * Opens/loads the saved leaderboard data.
     * @throws Exception Indicates conditions that a reasonable application might want to catch.
     */
    private void initTableData() {
        Vector ci = new Vector();
        ci.add("Player");
        ci.add("Score");

        tm = (DefaultTableModel) tblLeaderboard.getModel();
        try {
            FileInputStream fs = new FileInputStream(leaderboardFile);
            ObjectInputStream os = new ObjectInputStream(fs);

            tm.setDataVector((Vector<Vector>) os.readObject(), ci);
            os.close();
            fs.close();
        } catch (Exception e) {
        }
    }

    /**
     * Sorts the scores.
     */
    private void initTableSorter() {

        sorter = new TableRowSorter<>(tm);
        tblLeaderboard.setRowSorter(sorter);
        ArrayList<SortKey> keys = new ArrayList<>();
        keys.add(new SortKey(1, SortOrder.DESCENDING));

        sorter.setSortKeys(keys);


    }

    /**
     * Saves leaderboard information to a file.
     * @throws Exception Indicates conditions that a reasonable application might want to catch.
     */
    private void saveLeaderboard() {

        try {

            FileOutputStream fs = new FileOutputStream(leaderboardFile);
            ObjectOutputStream os = new ObjectOutputStream(fs);


            os.writeObject(tm.getDataVector());

            os.close();
            fs.close();
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMainMenu2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLeaderboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnMainMenu2.setText("Main Menu");
        btnMainMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenu2ActionPerformed(evt);
            }
        });

        tblLeaderboard.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Player", "Score"
                }
        ) {
            private Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.Integer.class
            };
            private boolean[] canEdit = new boolean[] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLeaderboard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnMainMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnMainMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * Button to navigate to the main menu.
     * @param evt Action event.
     */
    public void btnMainMenu2ActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnMainMenu2ActionPerformed
        showStartUp = new StartupForm();
        this.setVisible(false);
        Tetris.showStartup();

    } //GEN-LAST:event_btnMainMenu2ActionPerformed

    /**
     * Adding the players name to the leaderboard.
     * @param playerName Name of the player.
     * @param score Score the player obtained.
     */
    public void addPlayer(String playerName, int score) {

        tm.addRow(new Object[] {playerName, score});
        sorter.sort();
        saveLeaderboard();
        this.setVisible(true);

    }

    /**
     * Boolean to check if the leaderboard is visible.
     * @return
     */
    public boolean isLeaderboardVis() {
        return tblLeaderboard.isVisible();
    }

    /**
     * Accessor method to return the main menu button.
     * @return
     */
    public JButton getBtnMainMenu2() {
        return btnMainMenu2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Public menu button to access the JButton.
     */
    public javax.swing.JButton btnMainMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLeaderboard;
    // End of variables declaration//GEN-END:variables
}
