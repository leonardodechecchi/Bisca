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

    // set the number of players
    private void setNumPlayers() {
        Scanner scan = new Scanner(System.in);
        int numPlayers;
        do {
            System.out.print("Select the number of players -> ");
            numPlayers = scan.nextInt();
        } while (numPlayers < 2 || numPlayers > 8);
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player());
    }

    // set the name for each player
    private void setPlayersName() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for (Player p : players) {
            System.out.print("Player [" + ++i + "] select your name -> ");
            String name = scan.nextLine();
            p.setName(name);
        }
    }

    // print the introduction
    private static void printInit() {
        System.out.println("+-------+-------+-------+-------+");
        System.out.println("| BISCA | BISCA | BISCA | BISCA |");
        System.out.println("+-------+-------+-------+-------+");
    }

    private void playTurn(int currentTurn) {
        Scanner scan = new Scanner(System.in);
        for (Player p : players) {
            p.printHand();
            System.out.print(p.getName() + " select the number of hands -> ");
            p.setNumCards(scan.nextInt());
        }
        for (int turn = currentTurn; turn > 0; turn--) {
            for (Player p : players) {
                p.printHand();
                System.out.print(p.getName() + " select your card -> ");
                p.play(table, scan.nextInt() - 1);
            }
            Player handWinner = table.winner();
            handWinner.wonHand();
            Collections.sort(players); // the player who won is now the first player
        }
    }

    private void setResult() {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            if (p.getHandsTaken() != p.getNumCards()) {
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
        for (int round = 2; round > 0; round--) {
            deck.shuffleDeck();
            for (Player p : players) {
                p.drawCards(deck, round);
            }
            playTurn(round);
            setResult();
        }
    }

    public static void main(String[] args) {
        Game g = new Game(new ArrayList<>(), new Deck(), new Table());
        g.playGame();
    }
}
