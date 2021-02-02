public final class Game {

    private Player player1;
    private Player player2;
    private Deck deck;

    public Game(Player player1, Player player2, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
    }

    public void playGame() {
        deck.shuffleDeck();
        player1.drawCards(deck, 5);
        player2.drawCards(deck, 5);
    }
}
