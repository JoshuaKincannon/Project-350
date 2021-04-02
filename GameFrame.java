import javax.swing.JFrame;
/**********************************************************************
* This class is the blueprint for the frame that holds the JPanel
 * which draws and implements the logic of the game.
* */
public class GameFrame extends JFrame {

    GameFrame(){


        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
