public enum Suit {

    BASTONI(1),
    SPADE(2),
    COPPE(3),
    DENARI(4);

    private final int value;

    Suit(int seed) {
        this.value = seed;
    }

    public int getValue() {
        return this.value;
    }
}