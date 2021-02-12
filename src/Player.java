import java.util.ArrayList;

public class Player implements Comparable<Player> {

    private ArrayList<Card> hand;
    private String name;
    private int lives;
    private int numCards;
    private int numCardsTaken;

    public Player() {
        name = getIdentifier();
        hand = new ArrayList<>();
        lives = 3;
        numCards = 0;
        numCardsTaken = 0;
    }

    // lives
    public int getLives() {
        return this.lives;
    }

    public void loseLife() {
        this.lives--;
    }

    // num of cards to take
    public int getNumCards() {
        return this.numCards;
    }

    public void setNumCards(int numOfCards) {
        this.numCards = numOfCards;
    }

    // cards taken
    public int getHandsTaken() {
        return this.numCardsTaken;
    }

    public void wonHand() {
        this.numCardsTaken++;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void drawCards(Deck d, int numCards) {
        for (int i = 0; i < numCards; i++) {
            hand.add(d.getCardAtIndex(0));
            d.removeCardAtIndex(0);
        }
    }

    public void play(Table t, int index) {
        if (index < 0 || index > 5)
            throw new IllegalArgumentException();
        t.putCard(hand.get(index), this);
        hand.remove(index);
    }

    public void printHand() {
        int i = 0;
        System.out.println();
        for (Card c : hand) {
            System.out.println("[" + ++i + "]" + c.toString());
        }
    }

    public String getIdentifier() {
        return "Player " + this.hashCode();
    }

    public int compareTo(Player o) {
        return Integer.compare(this.numCardsTaken, o.numCardsTaken);
    }
}
