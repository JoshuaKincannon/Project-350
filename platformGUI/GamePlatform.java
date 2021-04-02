import javax.swing.*;
import java.awt.*;

public class GamePlatform {

    public static class GridPanel extends JPanel
    {


        public GridPanel()
        {
            setLayout(new GridLayout (3, 2));
            setBackground(Color.green);
            JButton b1 = new JButton("TicTacToe ");
            JButton b2 = new JButton("Uno");
            JButton b3 = new JButton("Snake");
            JButton b4 = new JButton("Othello");
            JButton b5 = new JButton("Tetris");
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(b5);
        }
    }




        public static void main(String[] args){
            JFrame frame = new JFrame("350Games");
            frame.setSize(500, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTabbedPane tp = new JTabbedPane();
            tp.addTab("Games", new GridPanel());
            tp.addTab("Leader Board", new GridPanel());


            frame.getContentPane().add(tp);

            //frame.pack();
            frame.setVisible(true);

    }
}
