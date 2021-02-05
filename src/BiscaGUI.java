import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BiscaGUI extends Frame implements WindowListener {

    private Label playersLabel;
    private List listOfPlayers;

    public BiscaGUI() {

        setLayout(new FlowLayout());

        playersLabel = new Label("Select the number of players");
        add(playersLabel);

        listOfPlayers = new List();
        for (int i = 0; i < 8; i++) {
            listOfPlayers.add(i + 1 + "");
        }
        add(listOfPlayers);

        addWindowListener(this);

        setTitle("Bisca");
        setSize(250, 250);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        BiscaGUI game = new BiscaGUI();
    }

}
