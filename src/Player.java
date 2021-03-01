import java.util.ArrayList;

public class Player implements Comparable<Player> {

    private ArrayList<Card> hand;
    private String name;
    private int id;
    private Score score;

    public Player(int id) {
        this.id = id;
        hand = new ArrayList<>();
        score = new Score();
    }

    public int getId() {
        return this.id;
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

    public void printHand() {
        int i = 0;
        System.out.println();
        for (Card c : hand) {
            System.out.println("[" + ++i + "]" + c.toString());
        }
    }

    public void play(Table t, int index) {
        if (index < 0 || index > 5)
            throw new IllegalArgumentException();
        t.putCard(hand.get(index), this);
        hand.remove(index);
    }

    public int compareTo(Player o) {
        return Integer.compare(score.numCardsTaken, o.score.numCardsTaken);
    }

    /* SCORE */

    public int getLives() {
        return score.lives;
    }

    public void loseLife() {
        score.lives--;
    }

    public int getNumCards() {
        return score.numCards;
    }

    public void setNumCards(int numOfCards) {
        score.numCards = numOfCards;
    }

    public int getHandsTaken() {
        return score.numCardsTaken;
    }

    public void wonHand() {
        score.numCardsTaken++;
    }
}
