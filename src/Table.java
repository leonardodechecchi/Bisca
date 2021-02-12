import java.util.HashMap;
import java.util.Map;

public class Table {

    private HashMap<Card, Player> table;

    public Table() {
        table = new HashMap<>();
    }

    public void putCard(Card c, Player p) {
        table.put(c, p);
    }

    public Player winner() {
        Player winner = null;
        int maxSuitsValue = 0;
        int maxValuesValue = 0;
        for (Map.Entry<Card, Player> entry : table.entrySet()) {
            if (entry.getKey().getSuitsValue() > maxSuitsValue) {
                maxSuitsValue = entry.getKey().getSuitsValue();
                maxValuesValue = entry.getKey().getValuesValue();
                winner = entry.getValue();
            }
            else if (entry.getKey().getSuitsValue() == maxSuitsValue) {
                if (entry.getKey().getValuesValue() > maxValuesValue) {
                    maxSuitsValue = entry.getKey().getSuitsValue();
                    maxValuesValue = entry.getKey().getValuesValue();
                    winner = entry.getValue();
                }
            }
        }
        return winner;
    }
}
