package com.company;

import java.io.*;
import java.util.*;
import javax.swing.*;

//***************************************************
// Filename: OthelloLeaderBoard.java
// Date: 03.17.21
// Author(s): Ariana Sherrod-Cavanaugh
//***************************************************
public class OthelloLeaderBoard {

     /** ArrayList of all the highscores **/
    private ArrayList<String[]> scores;

    /** String of the path of the highscores file **/
    private String path;

    /** JFrame of the leaderboard **/
    private JFrame frame;

    /**
     * Constructor for the OthelloLeaderBoard
     * Initializes scores array list.
     */
    public OthelloLeaderBoard(String filename){
        scores = new ArrayList<>();
        frame = new JFrame("OTHELLO LEADER BOARD");
        initializeHighScores(filename);
    }

    /**
     * Initializes the high scores array
     * list with the scores from
     * the highscores.txt file.
     */
    private void initializeHighScores(String filename){
        File highScores = new File(filename);
        try {
            highScores.createNewFile();
            path = highScores.getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = br.readLine();
            String[] a;
            while (line != null) {
                a = line.split(" ");
                line = br.readLine();
                scores.add(a);
            }

            for (int i = 1; i < scores.size(); ++i) {
                String[] key = scores.get(i);
                int keyScore = Integer.parseInt(key[1]);
                int j = i - 1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
                while (j >= 0 && Integer.parseInt(scores.get(j)[1]) < keyScore) {
                    scores.set(j + 1, scores.get(j));
                    j = j - 1;
                }
                scores.set(j + 1, key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(highScores,false);
            for(int j = 0; j < scores.size(); j++)
                writer.write(scores.get(j)[0] + " " + scores.get(j)[1] + "\n");

            writer.close();

        } catch (IOException e) {
//            return false;
        }
    }

    /**
     * Saves a high score.
     * @param score
     * @param name
     */
    protected void saveHighScore(int score, String name) {
        File highScores = new File(path);

        ArrayList<String> names = new ArrayList<>();
        for(int k = 0; k < scores.size(); k++)
            names.add(scores.get(k)[0].toLowerCase());

        while(names.contains(name.toLowerCase())){
            name = JOptionPane.showInputDialog(null, "Name taken!\nPlease enter a different name.").toLowerCase();
        }

        String[] addition = new String[]{name,""+score};

        if(scores.size() >= 1) {
            scores.add(addition);
            for (int i = 1; i < scores.size(); ++i) {
                String[] key = scores.get(i);
                int keyScore = Integer.parseInt(key[1]);
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && Integer.parseInt(scores.get(j)[1]) < keyScore) {
                    scores.set(j + 1, scores.get(j));
                    j = j - 1;
                }
                scores.set(j + 1, key);
            }

            if (scores.size() > 10)
                scores.remove(10);
        } else {
            scores.add(addition);
        }

        try {
            FileWriter writer = new FileWriter(highScores,false);
            for(int j = 0; j < scores.size(); j++)
                writer.write(scores.get(j)[0] + " " + scores.get(j)[1] + "\n");

            writer.close();

        } catch (IOException e) {
//            return false;
        }
    }

    /**
     * Checks that a high score can be saved.
     * @param score
     * @return
     */
    protected boolean checkHighScore(int score) {
        if(scores.size() < 10)
            return true;

        if (Integer.parseInt(scores.get(0)[1]) < score)
            return true;

        if (scores.size() == 10) {
            for (int i = 0; i < scores.size(); i++)
                if (Integer.parseInt(scores.get(i)[1]) < score)
                    return true;
        }

        return false;
    }

    /**
     * Displays the leader board for the
     * user to view.
     */
    protected void displayLeaderBoard(){
        String[][] namesAndScores = new String[scores.size()][];
        String[] columns = {"NAME", "SCORE"};

        for(int i = 0; i < scores.size(); i++)
            namesAndScores[i] = scores.get(i);

        JTable jt = new JTable(namesAndScores,columns){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jt.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jt);
        frame.add(sp);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    /**
     * Sets the scores arraylist
     * @param scores
     */
    public void setScores(ArrayList<String[]> scores) {
        this.scores = scores;
    }

    /**
     * Checks to see if the leaderboard is displayed
     * @return
     */
    protected boolean isShowing(){
        return frame.isShowing();
    }
}
