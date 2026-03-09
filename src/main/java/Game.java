import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Initializes the instance variables for the game
    private Player player1;
    private Player player2;
    private Deck deck;
    private GameViewer window;
    private ArrayList<Card> pile;
    public int counter = 1;

    public static final String INSTRUCTIONS = "Welcome to the beginning level of Egyptian rat slap!\n" + "Here are some rules: \n" +
            "The goal of the game is to end up with the most cards.\n" +
            "Each player places cards into a pile, and if the card they placed is a face\n" +
            "card they will win said pile and add it to their hand. \n Once one player has no cards, they have lost the game.";

    //Game constructor
    public Game() {
        //Creates the instance variable of the window
        this.window = new GameViewer(this);

        //Sets player1 and player2 names as according
        Scanner s = new Scanner(System.in);
        System.out.println("What is player 1 name?");
        String name1 = s.nextLine();

        System.out.println("What is player 2 name?");
        String name2 = s.nextLine();

        this.player1 = new Player(name1);
        this.player2 = new Player(name2);

        //Sets the card instance variables for the deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        pile = new ArrayList<>();

        //Creates the deck
        this.deck = new Deck(ranks, suits, values, window);

        //Distributes the deck while the deck has cards within it to the players hand
//        while (!deck.isEmpty()) {
//            deck.shuffle();
//            Card player1Cards = deck.deal();
//            player1.addCard(player1Cards);
//
//            Card player2Cards = deck.deal();
//            player2.addCard(player2Cards);
//        }


        // Simplified deck for a shorter game play
        for (int i = 0; i<4; i++){
            deck.shuffle();
            Card player1Cards = deck.deal();
            player1.addCard(player1Cards);

            Card player2Cards = deck.deal();
            player2.addCard(player2Cards);
        }

        window.repaint();
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public ArrayList<Card> getPile() {
        return pile;
    }

    public void playGame(){
        //Initializing the pile factor of this game which the players will be able to place cards into
        Scanner s = new Scanner(System.in);
        //Prints out the hand size of each player to keep track and makes sure a player has not
        // won the game before continuing
        while (player1.getHand().size() > 0 && player2.getHand().size() > 0) {
            if (hasWon()==null){
               //Player adds a card to the pile
                Card player1Card = player1.placeCard();
                s.nextLine();
                System.out.println( player1.getName() + " placed: " + player1Card + " ");
                pile.add(0, player1Card);
                window.repaint();
                counter++;

                //Checks to make sure the card is a face card, and if it is, the pile resets and the
                // Player gets the cards in the pile
                if (player1Card.faceCard()==true){
                    s.nextLine();
                    while (!pile.isEmpty()){
                        player1.addCard(pile.remove(0));

                    }
                    System.out.println(player1.getName() + " has won this pile.");
                    System.out.println(player1.getName() +" hand size: "+  player1.getHand().size() + " " + player2.getName() +" hand size: " + player2.getHand().size());
                }
                window.repaint();

                Card player2Card = player2.placeCard();
                s.nextLine();
                System.out.println(player2.getName() +" placed: " + player2Card + " ");
                pile.add(0,player2Card);
                window.repaint();
                counter++;

                if (player2Card.faceCard()==true){
                    s.nextLine();
                    while (!pile.isEmpty()){
                        player2.addCard(pile.remove(0));
                    }

                    System.out.println(player2.getName() + " has won this pile.");
                    System.out.println(player1.getName() +" hand size: "+  player1.getHand().size() +  player2.getName() + " hand size: "+  player2.getHand().size());
                }
            }

            //If one of the players has won, the game ends and whichever player won is crowned as so
            else if (hasWon().equals(player1)){
                System.out.println(player1.getName() +" has won!");
                break;
            }
            else if (hasWon().equals(player2)){
                System.out.println(player2.getName() +" has won!");
                break;
            }

        }
        window.repaint();
    }

    //Checks to see which player won the game, returns null if nobody has
    public Player hasWon(){
        //When the player has run out of cards or only has one left that is not a face card, the other player wins
        if (player1.getHand().size()<2 && !player1.getHand().getFirst().faceCard()){
            return player2;
        }
        else if (player2.getHand().size()<2 && !player1.getHand().getFirst().faceCard()){
            return player1;
        }
        return null;
    }

    //Prints out the instructions for the game
    public static void printInstructions(){
        System.out.println(INSTRUCTIONS);
    }


    //Initializes the game and the instructions for the game
    public static void main(String[] args) {
        printInstructions();
        Game game1 = new Game();
        game1.playGame();
    }
}
