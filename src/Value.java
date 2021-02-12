public enum Value {

    ASSO(1),
    DUE(2),
    TRE(3),
    QUATTRO(4),
    CINQUE(5),
    SEI(6),
    SETTE(7),
    FANTE(8),
    CAVALLO(9),
    RE(10);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}