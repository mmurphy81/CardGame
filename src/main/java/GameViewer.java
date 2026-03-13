import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame {
    //Instance variables
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private Game backend;
    private JButton restartButton;
    private JPanel gamePanel; // --- NEW: A dedicated panel for drawing ---

    public GameViewer(Game backend){
        this.backend= backend;

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Egyptian Rat Slap");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // --- NEW CODE: Create a custom JPanel for our graphics ---
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGameState(g); // Call your drawing logic here
            }
        };
        gamePanel.setLayout(null); // Keep absolute positioning for the button
        gamePanel.setBackground(new Color(31, 131, 41)); // Sets your green background!

        // Make this panel the main content area of the window
        this.setContentPane(gamePanel);
        // ---------------------------------------------------------

        // Setup Restart Button
        restartButton = new JButton("Restart Game");
        restartButton.setBounds(400, 850, 200, 50);
        restartButton.setVisible(false); // Hide it when the game first launches

        restartButton.addActionListener(e -> {
            backend.resetGame();
            new Thread(() -> backend.playGame()).start();
        });

        // Add the button to the gamePanel, not the JFrame
        gamePanel.add(restartButton);

        this.setVisible(true);
    }

    // --- RENAMED FROM paint(Graphics g) ---
    public void drawGameState(Graphics g) {
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
            ArrayList<Card> hand1 = backend.getPlayer1().getHand();
            ArrayList<Card> hand2 = backend.getPlayer2().getHand();

            Image back = new ImageIcon("src/main/resources/back.png").getImage();

            // If the players hand deck is 1 or empty, then that player loses
            if (hand1.size() == 1 || hand1.isEmpty()) {
                g.setColor(Color.WHITE);
                g.drawString(backend.getPlayer2().getName() + " has won!", 700, 500);

            }

            else if (hand2.size() == 1 || hand2.isEmpty()) {
                g.setColor(Color.WHITE);
                g.drawString(backend.getPlayer1().getName() + " has won!", 700, 500);

            }

            else {

                // normal gameplay screen
                g.setColor(Color.lightGray);
                if (backend.getCounter() % 2 == 1) g.drawRoundRect(90, 175,200,30,5,5);
                else g.drawRoundRect(90, 676,200,30,5,5);
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
    // --- NEW METHOD ---
    public void setRestartButtonVisible(boolean visible) {
        if (restartButton != null) {
            restartButton.setVisible(visible);
        }
    }
}