import java.util.ArrayList;

public class Player {

    private ArrayList<Cards> hand;
    private int hearts;
    private int numOfCards;

    public Player() {
        hand = new ArrayList<>();
        hearts = 3;
    }

    /**
     * @return the current hearts player
     */
    public int getHearts() {
        return this.hearts;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }

    /**
     * Draws cards according to the turn
     * @param d the deck where to draw
     * @param turn the current turn
     */
    public void drawCards(Deck d, int turn) {
        for (int i = hand.size(); i < turn; i++) {
            hand.add(d.getCardAtIndex(0));
            d.removeCardAtIndex(0);
        }
    }

    /**
     * Throw a card
     * @param t where to throw the card
     */
    public void play(Table t, int index) {
        if (index < 0 || index > 5)
            throw new IllegalArgumentException();
        t.addCard(hand.get(index), this);
        hand.remove(index);
    }

    public void loseLife() {
        this.hearts--;
    }

    /**
     * Print the current hand
     */
    public void printHand() {
        int i = 0;
        System.out.println();
        for (Cards c : hand) {
            System.out.println("[" + ++i + "]" + c.toString());
        }
    }


}
