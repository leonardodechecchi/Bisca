import java.util.ArrayList;

public class Player {

    private ArrayList<Cards> hand;
    private int hearts;

    public Player() {
        hand = new ArrayList<>();
        hearts = 3;
    }

    public int getHearts() {
        return this.hearts;
    }

    public void drawCards(Deck d, int turn) {
        for (int i = hand.size(); i < turn; i++) {
            hand.add(d.getCardAtIndex(0));
            d.deleteCardAtIndex(0);
        }
    }

    public void throwCard() {

    }
}
