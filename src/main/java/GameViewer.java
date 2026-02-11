import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    //Instance variables
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private Game backend;

    public GameViewer(Game backend){
        this.backend= backend;

        // Set up the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Egyptian Rat Slap");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 30));

        Card c = backend.getPlayer1().getHand().get(0);
        c.drawCard(g);
        System.out.println(c);
        }
}

