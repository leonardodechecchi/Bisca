import java.util.*;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Table table;

    public Game(ArrayList<Player> players, Deck deck, Table table) {
        this.players = players;
        this.deck = deck;
        this.table = table;
    }

    private void setNumPlayers() {
        Scanner scan = new Scanner(System.in);
        int nPlayers;
        do {
            System.out.print("Select the number of players -> ");
            nPlayers = scan.nextInt();
        } while (nPlayers < 2 || nPlayers > 8);
        for (int i = 0; i < nPlayers; i++)
            players.add(new Player());
    }

    private void setPlayersName() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for (Player p : players) {
            System.out.print("Player [" + ++i + "] select your name -> ");
            String name = scan.nextLine();
            p.setName(name);
        }
    }

    private void printInit() {
        System.out.println("+-------+-------+-------+-------+");
        System.out.println("| BISCA | BISCA | BISCA | BISCA |");
        System.out.println("+-------+-------+-------+-------+");
    }

    private void playRound(int currentRound) {
        Scanner scan = new Scanner(System.in);
        for (Player p : players) {
            p.printHand();
            System.out.print(p.getName() + " select the number of hands -> ");
            p.setNumCards(scan.nextInt());
        }
        for (int round = currentRound; round > 0; round--) {
            for (Player p : players) {
                p.printHand();
                System.out.print(p.getName() + " select your card -> ");
                p.play(table, scan.nextInt() - 1);
            }
        }
        Player roundWinner = table.recordRound();
        roundWinner.wonRound();
        Collections.sort(players); // the player who won is now the first player
    }

    private void setResult() {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            if (p.getNumRoundsWon() != p.getNumCards()) {
                p.loseLife();
                System.out.println(p.getName() + " lost a life");
                if (p.getLives() == 0) iterator.remove();
            }
        }
    }

    public void playGame() {
        printInit();
        setNumPlayers(); // Initialize the number of players
        setPlayersName(); // Initialize the players name
        for (int round = 5; round > 0; round--) {
            deck.shuffleDeck();
            for (Player p : players) {
                p.drawCards(deck, round);
            }
            playRound(round);
            setResult();
        }
    }

    /*
    public void playGame(int numPlayers) {

        Scanner in = new Scanner(System.in);

        printInit();

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
                    roundWinner.wonRound();
                }

                Iterator<Player> iterator = players.iterator();
                while (iterator.hasNext()) {
                    Player p = iterator.next();
                    if (p.getNumRoundsWon() != p.getNoCards()) {
                        p.loseLife();
                        if (p.getLives() == 0) iterator.remove();
                    }
                }
            }
        }
    }
     */

    public static void main(String[] args) {
        Game g = new Game(new ArrayList<>(), new Deck(), new Table());
        g.playGame();
    }

}
