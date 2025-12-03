import java.util.ArrayList;

public class Game {
    //Initializes the instance variables for the game
    private Player player1;
    private Player player2;
    private Deck deck;

    //Game constructor
    public Game() {
        //Sets player1 and player2 names as according
        this.player1 = new Player("Player1");
        this.player2 = new Player("Player2");

        //Sets the card instance variables for the deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        //Creates the deck
        this.deck = new Deck(ranks, suits, values);

        //Distributes the deck while the deck has cards within it to the players hand
        while (!deck.isEmpty()) {
            deck.shuffle();
            Card player1Cards = deck.deal();
            player1.addCard(player1Cards);

            Card player2Cards = deck.deal();
            player2.addCard(player2Cards);
        }
    }

    public void playGame(){
        //Initializing the pile factor of this game which the players will be able to place cards into
        ArrayList<Card> pile = new ArrayList<>();
        //Prints out the hand size of each player to keep track and makes sure a player has not
        // won the game before continuing
        while (player1.getHand().size() > 0 && player2.getHand().size() > 0) {
            if (hasWon()==null){
               //Player adds a card to the pile
                Card player1Card = player1.placeCard();
                System.out.println("Player 1 placed: " + player1Card + " ");
                pile.add(player1Card);

                //Checks to make sure the card is a face card, and if it is, the pile resets and the
                // Player gets the cards in the pile
                if (player1Card.faceCard()==true){
                    for (int i =0; i<pile.size(); i++){
                        player1.addCard(pile.get(i));
                        pile.remove(i);
                    }
                    System.out.println("Player 1 has won this pile.");
                    System.out.println("Player1 hand size: "+  player1.getHand().size() + " Player 2 hand size: "+  player2.getHand().size());
                }

                Card player2Card = player2.placeCard();
                System.out.println("Player 2 placed: " + player2Card + " ");
                pile.add(player2Card);
                if (player2Card.faceCard()==true){
                    for (int i =0; i<pile.size(); i++){
                        player2.addCard(pile.get(i));
                        pile.remove(i);
                    }

                    System.out.println("Player 2 has won this pile.");
                    System.out.println("Player1 hand size: "+  player1.getHand().size() + " Player 2 hand size: "+  player2.getHand().size());
                }
            }

            //If one of the players has won, the game ends and whichever player won is crowned as so
            else if (hasWon().equals(player1)){
                System.out.println("Player 1 has won!");
                break;
            }
            else if (hasWon().equals(player2)){
                System.out.println("Player 2 has won!");
                break;
            }

        }
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
        System.out.println("Welcome to the beginning level of Egyptian rat slap!\n" + "Here are some rules: \n" +
                "The goal of the game is to end up with the most cards." +
                "Each player places cards into a pile, and if the card they placed is a face " +
                "card they will win said pile and add it to their hand. Once one player gets to 1 card, they have lost the game.");
    }


    //Initializes the game and the instructions for the game
    public static void main(String[] args) {
        printInstructions();
        Game game1 = new Game();
        game1.playGame();
    }
}
