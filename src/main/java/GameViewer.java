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
        // Initializes the window background
        g.setColor(new Color(31, 131, 41));
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Initializes the color and font for the text
        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Serif", Font.PLAIN, 30));


        // If the player has not been initialized, the instruction screen will display
        if (backend.getPlayer1() == null){
            String[] instructions = backend.INSTRUCTIONS.split("\n");

            for (int i =0; i<instructions.length; i++){
                g.drawString(instructions[i], 100, 200+(i*30));
            }
        }
        // If the player HAS been initialized, it gets their hand and displays each deck face down
        else {
            ArrayList<Card> hand1 = new ArrayList<>();
            hand1 = backend.getPlayer1().getHand();

            ArrayList<Card> hand2 = new ArrayList<>();
            hand2 = backend.getPlayer2().getHand();

            Image back = new ImageIcon("src/main/resources/back.png").getImage();


            // If the players hand deck is 1 or empty, then that player loses and it displays the winners name
            if (hand1.size() == 1 || hand1.isEmpty()) {
                // winner screen
                g.setColor(new Color(31,131,41));
                g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.WHITE);
                g.drawString(backend.getPlayer2().getName() + " has won!", 700, 500);
            }

            else if (hand2.size() == 1 || hand2.isEmpty()) {
                g.setColor(new Color(31,131,41));
                g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.WHITE);
                g.drawString(backend.getPlayer1().getName() + " has won!", 700, 500);
            }

            else {
                // normal gameplay screen
                g.drawString(backend.getPlayer1().getName() + "'s Cards", 100, 200);
                g.drawString(backend.getPlayer2().getName() + "'s Cards", 100, 700);

                g.drawImage(back, 400, 50, 150, 200, this);
                g.drawImage(back, 400, 600, 150, 200, this);
            }


            //While there is a pile, display the most recently added card
            if (!backend.getPile().isEmpty()){
                Card topP = backend.getPile().get(0);
                topP.drawCard(g, 400, 300);

            }

        }
        }
}

