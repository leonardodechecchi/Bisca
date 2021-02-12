public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Suit seed, Value value) {
        this.suit = seed;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Value getValue() {
        return this.value;
    }

    public int getSuitsValue() {
        return suit.getValue();
    }

    public int getValuesValue() {
        return value.getValue();
    }

    public String toString() {
        return "[" + this.suit + ", " + this.value + "]";
    }
}
