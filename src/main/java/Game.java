public class Game {
    static void main(String[] args) {
        Deck d = new Deck(new String[]{"A", "2", "3"}, new String[]{"Hearts", "Clubs"}, new int []{1,2,3});
        d.shuffle();
        System.out.println();
    }
}
