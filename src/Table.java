import java.util.HashMap;
import java.util.Map;

public class Table {

    private HashMap<Cards, Player> table;

    public Table() {
        table = new HashMap<>();
    }

    public void addCard(Cards c, Player p) {
        table.put(c, p);
    }

    public Player recordRound() {
        Player winner = null;
        int maxSeedsValue = 0;
        int maxValuesValue = 0;
        for (Map.Entry<Cards, Player> entry : table.entrySet()) {
            if (entry.getKey().getSeedsValue() > maxSeedsValue) {
                maxSeedsValue = entry.getKey().getSeedsValue();
                maxValuesValue = entry.getKey().getValuesValue();
                winner = entry.getValue();
            }
            else if (entry.getKey().getSeedsValue() == maxSeedsValue) {
                if (entry.getKey().getValuesValue() > maxValuesValue) {
                    maxSeedsValue = entry.getKey().getSeedsValue();
                    maxValuesValue = entry.getKey().getValuesValue();
                    winner = entry.getValue();
                }
            }
        }
        return winner;
    }
}
