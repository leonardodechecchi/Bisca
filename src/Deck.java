import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                deck.add(new Card(s, v));
            }
        }
    }

    public Card getCardAtIndex(int index) {
        return deck.get(index);
    }

    public void removeCardAtIndex(int index) {
        deck.remove(index);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
