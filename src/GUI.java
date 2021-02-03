import java.awt.*;

public class GUI extends Frame {

    /**
     * Ci sono due tipi di GUI elementi:
     * 1. Components: Button, Label, TextField.
     *
     * 2. Container: Frame, Panel usati per contenere componenti in uno specifico layout.
     * Un Frame è il top-level contenitore di un programma AWT.
     * Un Panel è un'area rettangolare usata per raggruppare componenti.
     *
     *
     */

    public GUI() {

    }

    Panel pnl = new Panel();
    Button btn = new Button("Press");

    public void boh () {
        pnl.add(btn);
    }
}
