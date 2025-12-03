import java.util.ArrayList;

public class Player {
    //Initializes the instance variables for the player
    private int points;
    private ArrayList<Card> hand;
    private String name;

    //The constructor for the player that takes in just the name
    public Player(String name){
       this.name = name;
       points=0;
       this.hand = new ArrayList<Card>();
    }

    //Constructor that takes in a name and a hand
    public Player(String name, ArrayList<Card> hand){
        this.name = name;
        this.hand = hand;
        points=0;
    }

    //Getter for points
    public int getPoints() {
        return points;
    }

    //Getter for hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Adds points to the number of points
    public void addPoints(int numPoints){
        points+=numPoints;
    }

    //Adds a card to the hand
    public void addCard(Card newCard){
        hand.add(newCard);
    }

    //Allows the players do be able to place cards into the pile in order to win the game
    public Card placeCard(){
        Card recent = hand.getFirst();
        hand.removeFirst();
        return recent;
    }

    //A toString for the player class
    public String toString(){
        return name + " has " + points + " points" +"/n" + name + "'s cards:" + hand;
    }
}
