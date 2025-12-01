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
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.deck = new Deck(ranks, suits, values);

        while (!deck.isEmpty()) {
            Card player1Cards = deck.deal();
            player1.addCard(player1Cards);

            Card player2Cards = deck.deal();
            player2.addCard(player2Cards);
        }
    }

    public String printInstructions(){
        return "Welcome to Egyption rat slap!" + "/n" + "Here are some rules: " + "/n" +
                "The goal of the game is to end up with the most cards. You can win cards by placing face cards" +
                " and your opponent will need to place the said amount of cards corresponding to whatever face card you placed." +
                " If you place a Jack, your opponent needs to place one card. If that card is a face card too, you will need" +
                " to place a certain amount of cards as well. Jack = 1 card, Queen = 2 cards, King = 3 cards, Ace = 4 cards.";
    }
    public boolean wonDeck(){

    }

    public void playCard(Card card){
        while (wonDeck!= true){
            deck+=player1Deck.deal();
            deck+=player2Deck.deal();
        }

    }

    static void main(String[] args) {

    }
}
