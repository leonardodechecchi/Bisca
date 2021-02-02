public enum Seeds {

    BASTONI(1),
    SPADE(2),
    COPPE(3),
    DENARI(4);

    private int value;

    Seeds(int seed) {
        this.value = seed;
    }

    public int getValue() {
        return this.value;
    }

}