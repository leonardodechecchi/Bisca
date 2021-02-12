import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FirstWindow extends JFrame implements ListSelectionListener {

    private JList list;
    private JPanel grid = new JPanel(new GridLayout(1, 2));
    private JLabel statusBar = new JLabel("Ready");

    public FirstWindow() {
        initUI();
    }

    private void initUI() {
        setTitle("Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        createAll();
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);
    }

    public void createAll() {
        String[] players = {"2", "3", "4", "5", "6", "7", "8"};
        list = new JList(players);

        // creates a new Bar
        JMenuBar menuBar = new JMenuBar();

        // creates a new Button Menu "File"
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // creates a new Button Menu "View"
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);

        // creates a new MenuItem "Exit"
        JMenuItem itemMenu = new JMenuItem("Exit");
        itemMenu.setMnemonic(KeyEvent.VK_E);
        itemMenu.addActionListener((event) -> System.exit(0));

        // creates a new MenuItem "Show status bar"
        JCheckBoxMenuItem checkBox = new JCheckBoxMenuItem("Show status bar");
        checkBox.setMnemonic(KeyEvent.VK_S);
        checkBox.setSelected(true);
        checkBox.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                    statusBar.setVisible(true);
            else
                statusBar.setVisible(false);
        });

        viewMenu.add(checkBox);
        fileMenu.add(itemMenu);
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

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
            g.playGame();
        }
    }

    public static void main(String[] args) {
        new FirstWindow();
    }
}
