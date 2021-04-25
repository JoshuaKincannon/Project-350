package com.company.GameP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlatform {

    private JFrame frame;

    private JTabbedPane tp;

    public GamePlatform(){
        frame = new JFrame("350Games");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp = new JTabbedPane();
        tp.addTab("Games", new GridPanel());

        frame.getContentPane().add(tp);

        frame.setVisible(true);
    }

    public static class GridPanel extends JPanel implements ActionListener {

        private JButton[] buttons;

        private JButton tttButton;

        private JButton unoButton;

        private JButton tetrisButton;

        private JButton snakeButton;

        private JButton othelloButton;

        /**
         * Constructor for the GridPanel
         */
        public GridPanel() {
            setLayout(new GridLayout(3, 2)); //columns, rows
            setBackground(Color.black);

            //initializing buttons for each Game
            tttButton = new JButton("TicTacToe ");
            unoButton = new JButton("Uno");
            snakeButton = new JButton("Snake");
            othelloButton = new JButton("Othello");
            tetrisButton = new JButton("Tetris");

            buttons = new JButton[]{tttButton, unoButton, snakeButton, othelloButton, tetrisButton};

            for (JButton i : buttons) {
                add(i);
                i.addActionListener(this);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object pressed = e.getSource();

            if (pressed == snakeButton) {
                new GameFrame();
            }
            if (pressed == othelloButton) {
//                new OthelloGUI();
            }
            if (e.getSource() == tetrisButton) {
                if (e.getSource() == tetrisButton) {
                    new Tetris().main(new String[]{"arg1", "arg2"});
                }
            }
            if (e.getSource() == unoButton) {

            }
            if (e.getSource() == tttButton) {
                new TicTacToeGUI();
            }
        }

        public JButton[] getButtons() {
            return buttons;
        }

        public JButton getTttButton() {
            return tttButton;
        }

        public JButton getUnoButton() {
            return unoButton;
        }

        public JButton getTetrisButton() {
            return tetrisButton;
        }

        public JButton getSnakeButton() {
            return snakeButton;
        }

        public JButton getOthelloButton() {
            return othelloButton;
        }
    }

    public boolean isShowing(){
        return frame.isVisible();
    }
}