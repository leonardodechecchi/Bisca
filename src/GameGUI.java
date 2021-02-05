import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// This class is a FRAME
public class GameGUI extends Frame implements ActionListener, WindowListener {

    private TextField tfCount;  // Declare a TextField component
    private Button btnCount;    // Declare a Button component
    private int count = 0;      // Counter's value

    public GameGUI() {

        setLayout(new FlowLayout());

        add(new Label("Counter"));

        tfCount = new TextField("0", 10);
        tfCount.setEditable(false);       // read-only
        add(tfCount);                     // "super" Frame adds TextField

        btnCount = new Button("Count");  // Construct the Button
        add(btnCount);

        btnCount.addActionListener(this);
        // btnCount (source object) fires ActionEvent upon clicking
        // btnCount adds "this" object as an ActionEvent listener

        addWindowListener(this);
        // "super" Frame (source object) fires WindowEvent.
        // "super" Frame adds "this" object as a WindowEvent listener.

        setTitle("Bisca");
        setSize(250, 250);
        // inherited from Frame
        // set the initial size and the title of the Frame

        setVisible(true);
        // is invoked to show the display



    }

    public void actionPerformed(ActionEvent e) {
        ++count;
        tfCount.setText(count + "");
    }

    public static void main(String[] args) {
        GameGUI game = new GameGUI();
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }
}
