package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlatform {
    public static class GridPanel extends JPanel implements ActionListener {

        private JButton[] buttons;

        private JButton tttButton;

        private JButton unoButton;

        private JButton tetrisButton;

        private JButton snakeButton;

        private JButton othelloButton;

        private JButton uploadButton;

        /**
         *
         */
        public GridPanel() {
            setLayout(new GridLayout (3, 2)); //columns, rows
            setBackground(Color.green);

            //initializing buttons for each Game
            tttButton = new JButton("TicTacToe ");
            unoButton = new JButton("Uno");
            snakeButton = new JButton("Snake");
            othelloButton = new JButton("Othello");
            tetrisButton = new JButton("Tetris");
            uploadButton = new JButton("Upload Game");

            buttons = new JButton[]{tttButton,unoButton,snakeButton,othelloButton,tetrisButton,uploadButton};

            for(JButton i : buttons) {
                add(i);
                i.addActionListener(this);
            }
        }

        @Override 
        public void actionPerformed(ActionEvent e) {
            Object pressed = e.getSource();

            if(pressed == othelloButton){
                new OthelloGUI();
            }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object pressed = e.getSource();

            if(pressed == othelloButton){
                new OthelloGUI();
            }
        }
    }
    
  
    
    /**
    * This will launch the Tetris game when tetrisbutton is pressed.
    *
    */
    @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tetrisButton){
                new Tetris().main(new String[]{"arg1", "arg2"});
            }
        }
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args){
        JFrame frame = new JFrame("350Games");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Games", new GridPanel());
        tp.addTab("Leader Board", new GridPanel());


        frame.getContentPane().add(tp);
        /***********************************************************************
         frame.pack(); if frame pack is enacted we cannot have a custom sized
         window
         ***********************************************************************/
        frame.setVisible(true);
    }
}
