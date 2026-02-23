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
        g.setColor(new Color(31, 131, 41));
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1 = backend.getPlayer1().getHand();

        ArrayList<Card> hand2 = new ArrayList<>();
        hand2 = backend.getPlayer2().getHand();

        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 30));

        if (!hand1.isEmpty()) {
            Card top1 = hand1.get(0);
            top1.drawCard(g, 400, 50);

        }

        if (!hand2.isEmpty()) {
            Card top2 = hand2.get(0);
            top2.drawCard(g, 400, 550);

        }

        if (!backend.getPile().isEmpty()){
            Card topP = backend.getPile().get(0);
            topP.drawCard(g, 400, 300);
        }


        g.drawString(backend.getPlayer1().getName() + "'s Cards", 100, 200);
        g.drawString(backend.getPlayer2().getName() + "'s Cards", 100, 700);
        }
}

