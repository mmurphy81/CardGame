import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] rank, String[] suit, int[] values) {
        cards = new ArrayList<Card>();
        cardsLeft = cards.size();
        for (int i=0; i<rank.length; i++){
            for (int j = 0; j<suit.length; j++){
                Card x = new Card(rank[i], suit[j], values[i]);
                cards.set(i, x);
                cardsLeft ++;
            }
        }
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
        for (int i = cardsLeft; i>0; i--){
            int r = (int)(Math.random()*(getCardsLeft()-1)+1);
            cards.set(i, cards.get(r));
        }
    }
}
