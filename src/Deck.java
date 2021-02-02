import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Cards> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (Seeds s : Seeds.values()) {
            for (Values v : Values.values()) {
                deck.add(new Cards(s, v));
            }
        }
    }

    public Cards getCardAtIndex(int index) {
        return deck.get(index);
    }

    public void removeCardAtIndex(int index) {
        deck.remove(index);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
