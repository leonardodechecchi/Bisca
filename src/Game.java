import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;
    private Deck deck;
    private Table table;

    public Game(ArrayList<Player> players, Deck deck, Table table) {
        this.players = players;
        this.deck = deck;
        this.table = table;
    }

    public void playGame() {

        Scanner in = new Scanner(System.in);

        for (int turn = 5; turn > 0; turn--) {
            for (Player p : players) {
                p.drawCards(deck, turn);
            }
            for (int round = turn; round > 0; round--) {
                Collections.sort(players);
                for (Player p : players) {
                    p.printHand();
                    System.out.println("[" + p.getIdentifier() + "] SELECT NUM OF CARDS: ");
                    p.setNumOfCards(in.nextInt());
                }
                for (Player p : players) {
                    p.printHand();
                    System.out.println("[" + p.getIdentifier() + "] SELECT A CARD TO THROW: ");
                    p.play(table, in.nextInt());
                }
                Player roundWinner = table.recordRound();
                roundWinner.setNumRoundVinti();
            }
            for (Player p : players) {
                if (p.getNumRoundVinti() != p.getNumOfCards())
                    p.loseLife();
            }
        }
    }

    public static void main(String[] args) {
        Game g = new Game(new Player(), new Player(), new Deck(), new Table());
        g.playGame();
    }
}
