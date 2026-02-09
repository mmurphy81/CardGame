import javax.swing.*;

public class GameViewer extends JFrame {
    //Instance variables
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private Game backend;

    public GameViewer(Game backend){
        this.backend= backend;

        // Set up the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Egyptian Rat Slap");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

}
