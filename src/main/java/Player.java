import java.util.ArrayList;

public class Player {
    private int points;
    private ArrayList<Card> hand;
    private String name;

    public Player(String name){
       this.name = name;
       points=0;
       this.hand = new ArrayList<Card>();
    }
    public Player(String name, ArrayList<Card> hand){
        this.name = name;
        this.hand = hand;
        points=0;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int numPoints){
        points+=numPoints;
    }
    public void addCard(Card newCard){
        hand.add(newCard);
    }

    public String toString(){
        return name + " has " + points + " points" +"/n" + name + "'s cards:" + hand;
    }
}
