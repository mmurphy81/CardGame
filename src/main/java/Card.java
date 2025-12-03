public class Card {
    //Initializes instance variables for the card
    private String rank;
    private String suit;
    private int value;

    //The constructor for the card
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    //Getter for rank
    public String getRank() {
        return rank;
    }

    //Getter for suit
    public String getSuit() {
        return suit;
    }

    //Getter for value
    public int getValue() {
        return value;
    }

    //Setter for rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    //Setter for suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    //Setter for value
    public void setValue(int value) {
        this.value = value;
    }

    //Checks to see if the card is a face card, returns true if it is and false if not
    public boolean faceCard(){
        if(rank.equals("Jack")|| rank.equals("Queen")||rank.equals("King")|| rank.equals("A")){
            return true;
        }
        return false;
    }

    //toString for the card
    public String toString(){
        return rank + " of " + suit;
    }
}
