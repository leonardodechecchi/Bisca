import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Deck deck;
    private Table table;

    public Game(Player player1, Player player2, Deck deck, Table table) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.table = table;
    }

    public Result playGame() throws InterruptedException {

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println(player1);
            System.out.println(player2);

            deck.shuffleDeck();

            player1.drawCards(deck, 2);
            player2.drawCards(deck, 2);

            player1.printHand();
            System.out.print("[Player1] SELECT THE NUMBER OF TAKES: ");
            player1.setNumOfCards(in.nextInt());

            player2.printHand();
            System.out.print("[Player2] SELECT THE NUMBER OF TAKES: ");
            player2.setNumOfCards(in.nextInt());

            int i = 2;
            while (i > 0) {
                int numPlayer1 = 0;
                int numPlayer2 = 0;
                System.out.println("\n[Player1] SELECT WHICH CARD TO THROW: ");
                player1.printHand();
                player1.play(table, in.nextInt() - 1);
                System.out.println("\n[Player2] SELECT WHICH CARD TO THROW: ");
                player2.printHand();
                player2.play(table, in.nextInt() - 1);
                i--;

                Player winner = table.recordResult();
                if(winner.equals(player1))
                   return Result.player1;
                else if (winner.equals(player2))
                    return Result.player2;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Game g = new Game(new Player(), new Player(), new Deck(), new Table());
        g.playGame();
    }
}
