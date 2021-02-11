import java.util.ArrayList;

public class Player implements Comparable<Player> {

    private ArrayList<Cards> hand;
    private String name;
    private int lives;
    private int numCards;
    private int numRoundsWon;

    public Player() {
        name = getIdentifier();
        hand = new ArrayList<>();
        lives = 3;
        numCards = 0;
        numRoundsWon = 0;
    }

    public int getLives() {
        return this.lives;
    }

    public int getNumCards() {
        return this.numCards;
    }

    public int getNumRoundsWon() {
        return this.numRoundsWon;
    }

    public void setNumCards(int numOfCards) {
        if (numOfCards >= 0)
            this.numCards = numOfCards;
        else throw new IllegalArgumentException();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void wonRound() {
        this.numRoundsWon++;
    }

    public void loseLife() {
        this.lives--;
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
        t.addCard(hand.get(index), this);
        hand.remove(index);
    }

    public void printHand() {
        int i = 0;
        System.out.println();
        for (Cards c : hand) {
            System.out.println("[" + ++i + "]" + c.toString());
        }
    }

    public String getIdentifier() {
        return "Player " + this.hashCode();
    }

    public int compareTo(Player o) {
        return Integer.compare(this.numRoundsWon, o.numRoundsWon);
    }
}
