public class Game {
    private Player player;
    private Deck deck;

    public Game(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;

    }
    public String printInstructions(){
        return "Welcome to Egyption rat slap!" + "/n" + "Here are some rules: " + "/n" +
                "The goal of the game is to end up with the most cards. You can win cards by placing face cards" +
                " and your opponent will need to place the said amount of cards corresponding to whatever face card you placed." +
                " If you place a Jack, your opponent needs to place one card. If that card is a face card too, you will need" +
                " to place a certain amount of cards as well. Jack = 1 card, Queen = 2 cards, King = 3 cards, Ace = 4 cards.";
    }

    static void main(String[] args) {

    }
}
