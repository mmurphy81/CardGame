import java.util.ArrayList;

public class Deck {
    //Initializes the instance variables for the deck
    private ArrayList<Card> cards;
    private int cardsLeft;

    //Constructor for the deck
    public Deck(String[] rank, String[] suit, int[] values) {
        cards = new ArrayList<Card>();
        for (int i=0; i<rank.length; i++){
            for (int j = 0; j<suit.length; j++){
                //Initializes the cards themselves with their instance variables and adds them to the deck
                Card x = new Card(rank[i], suit[j], values[i]);
                cards.add(x);
            }
        }
        //Updates the amount of cardsLeft, aka the cards in the deck
        cardsLeft = cards.size();
    }

    //Checks to see if the deck is empty, returns true if it is and false if it is not
    public boolean isEmpty(){
        if (cardsLeft==0){
            return true;
        }
        return false;
    }

    //Getter for the number of cards left
    public int getCardsLeft() {
        return cardsLeft;
    }

    //Function that deals cards to players as long as there are cards in the deck
    public Card deal(){
        if (cardsLeft==0){
            return null;
        }

        //Updates the deck by removing the dealt card and returns the card to the suer
        Card dealtCard = cards.get(cardsLeft-1);
        cardsLeft--;
        return dealtCard;
    }

    //Shuffles the deck
    public void shuffle(){
        //Loops through all of the cards and changes the values within them
        for (int i = cardsLeft - 1; i>=0; i--){
            int r = (int)(Math.random()*(i));
            Card temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }
}
