import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    public Game() {
        this.player1 = new Player("Player1");
        this.player2 = new Player("Player2");
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        this.deck = new Deck(ranks, suits, values);

        while (!deck.isEmpty()) {
            deck.shuffle();
            Card player1Cards = deck.deal();
            player1.addCard(player1Cards);

            Card player2Cards = deck.deal();
            player2.addCard(player2Cards);
        }
    }

    public void playGame(){
        ArrayList<Card> pile = new ArrayList<>();
        while (player1.getHand().size() > 0 && player2.getHand().size() > 0) {
            System.out.println("Player1 hand size: "+  player1.getHand().size() + " Player 2 hand size: "+  player2.getHand().size());
            if (hasWon()==null){
                Card player1Card = player1.placeCard();
                System.out.print(player1Card + " ");
                pile.add(player1Card);

                if (player1Card.faceCard()==true){
                    for (int i =0; i<pile.size(); i++){
                        player1.addCard(pile.get(i));
                        pile.remove(i);
                    }
                    System.out.println("Player 1 has won this pile.");
                }

                Card player2Card = player2.placeCard();
                System.out.print(player2Card + " ");
                pile.add(player2Card);
                if (player2Card.faceCard()==true){
                    for (int i =0; i<pile.size(); i++){
                        player2.addCard(pile.get(i));
                        pile.remove(i);
                    }

                    System.out.println("Player 2 has won this pile.");
                }
            }

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

    public Player hasWon(){
        if (player1.getHand().size()<2){
            return player2;
        }
        else if (player2.getHand().size()<2){
            return player1;
        }
        return null;
    }

    public static void printInstructions(){
        System.out.println("Welcome to Egyption rat slap!\n" + "Here are some rules: \n" +
                "The goal of the game is to end up with the most cards. You can win cards by placing face cards" +
                "When someone places a facecard, they win the deck.");
    }


    public static void main(String[] args) {
        printInstructions();
        Game game1 = new Game();
        game1.playGame();
    }
}
