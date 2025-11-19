import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] rank, String[] suit, int[] values) {
        cards = new ArrayList<Card>();
        for (int i=0; i<rank.length; i++){
            for (int j = 0; j<suit.length; j++){
                Card x = new Card(rank[i], suit[j], values[i]);
                cards.add(x);
            }
        }
        cardsLeft = cards.size();
    }

    public boolean isEmpty(){
        if (cardsLeft==0){
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if (cardsLeft==0){
            return null;
        }

        Card dealtCard = cards.get(cardsLeft);
        cardsLeft--;
        return dealtCard;
    }

    public void shuffle(){
        for (int i = cardsLeft - 1; i>=0; i--){
            int r = (int)(Math.random()*(i));
            Card temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }
}
