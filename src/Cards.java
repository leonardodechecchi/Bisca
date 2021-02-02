public class Cards {

    private Seeds seed;
    private Values value;

    public Cards(Seeds seed, Values value) {
        this.seed = seed;
        this.value = value;
    }

    public Seeds getSeed() {
        return this.seed;
    }

    public Values getValue() {
        return this.value;
    }

    public int getSeedsValue() {
        return seed.getValue();
    }

    public int getValuesValue() {
        return value.getValue();
    }

    public String toString() {
        return "[" + this.seed + ", " + this.value + "]";
    }
}
