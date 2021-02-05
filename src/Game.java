import java.util.*;

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

        printInit();

        System.out.print("SELEZIONA IL NUMERO DI GIOCATORI -->  ");
        int numPlayers = in.nextInt();
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player());

        while (players.size() > 1) {
            for (int turn = 5; turn > 0; turn--) {
                System.out.println("TURN " + turn);
                deck.shuffleDeck();
                for (Player p : players)
                    p.drawCards(deck, turn);

                for (int round = turn; round > 0; round--) {
                    System.out.println("ROUND " + round);
                    Collections.sort(players);

                    for (Player p : players) {
                        System.out.println("TOCCA AL GIOCATORE [" + p.getIdentifier() + "]");
                        p.printHand();
                        System.out.print("IO DICO --> ");
                        p.setNumOfCards(in.nextInt(), turn);
                        System.out.println();
                    }

                    for (Player p : players) {
                        System.out.println("TOCCA AL GIOCATORE [" + p.getIdentifier() + "]");
                        p.printHand();
                        System.out.print("SELEZIONA LA CARTA DA LANCIARE --> ");
                        p.play(table, in.nextInt());
                        System.out.println();
                    }

                    Player roundWinner = table.recordRound();
                    roundWinner.increaseWinRound();
                }

                Iterator<Player> iterator = players.iterator();
                while (iterator.hasNext()) {
                    Player p = iterator.next();
                    if (p.getNumRoundVinti() != p.getNumOfCards()) {
                        p.loseLife();
                        if (p.getHearts() == 0) iterator.remove();
                    }
                }
            }
        }
    }

    private void printInit() {
        System.out.println("+-------+-------+-------+-------+");
        System.out.println("| BISCA | BISCA | BISCA | BISCA |");
        System.out.println("+-------+-------+-------+-------+");
    }

    public static void main(String[] args) {
        Game g = new Game(new ArrayList<>(), new Deck(), new Table());
        g.playGame();
    }
}
