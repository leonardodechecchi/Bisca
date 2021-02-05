import java.util.ArrayList;

public class Player implements Comparable<Player> {

    private ArrayList<Cards> hand;
    private int hearts;
    private int numOfCards;
    private int numRoundVinti;

    public Player() {
        hand = new ArrayList<>();
        hearts = 3;
        numRoundVinti = 0;
    }

    /**
     * @return the current hearts player
     */
    public int getHearts() {
        return this.hearts;
    }

    public void setNumOfCards(int numOfCards, int turn) {
        if (numOfCards >= 0 && numOfCards <= turn)
            this.numOfCards = numOfCards;
        else throw new IllegalArgumentException();
    }

    public int getNumOfCards() {
        return this.numOfCards;
    }

    public void increaseWinRound() {
        numRoundVinti++;
    }

    public int getNumRoundVinti() {
        return numRoundVinti;
    }

    /**
     * Draws cards according to the turn
     * @param d the deck where to draw
     * @param turn the current turn
     */
    public void drawCards(Deck d, int turn) {
        for (int i = 0; i < turn; i++) {
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
        for (Cards c : hand) {
            System.out.println("[" + ++i + "]" + c.toString());
        }
    }

    public String getIdentifier() {
        return "Player " + this.hashCode();
    }

    public int compareTo(Player o) {
        return Integer.compare(this.numRoundVinti, o.numRoundVinti);
    }
}
