import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1 = Game.player1.getHand();

        ArrayList<Card> hand2 = new ArrayList<>();
        hand2 = Game.player2.getHand();

        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 30));

        for (int i =0; i<hand1.size(); i++){
            Card c = hand1.get(0);
            c.drawCard(g);
        }

        for (int i =0; i<hand2.size(); i++){
            Card c = hand1.get(0);
            c.drawCard(g);
        }


        g.drawString(backend.getPlayer1().getName() + "'s Cards", 100, 200);
        g.drawString(backend.getPlayer2().getName() + "'s Cards", 100, 700);
        }
}

