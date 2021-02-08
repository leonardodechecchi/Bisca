import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class FirstWindow extends JFrame implements ListSelectionListener {

    private JList list;
    private JPanel grid = new JPanel(new GridLayout(1, 2));

    public FirstWindow() {

        setTitle("Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] players = {"2", "3", "4", "5", "6", "7", "8"};
        list = new JList(players);

        list.addListSelectionListener(this);

        grid.add(new JLabel("Seleziona il numero di giocatori "));
        grid.add(list);
        getContentPane().add(new JLabel("BISCA", JLabel.CENTER), BorderLayout.NORTH);
        getContentPane().add(grid);
        pack();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            JList source = (JList) e.getSource();
            String supp = source.getSelectedValue().toString();
            Game g = new Game(new ArrayList<>(), new Deck(), new Table());
            g.playGame(Integer.parseInt(supp));
        }
    }

    public static void main(String[] args) {
        new FirstWindow();
    }
}
