import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Display extends JFrame implements ActionListener {
    MainPanel mainPanel;
    int cellSize, fps;
    double dt;
    Timer frameTimer;
    ArrayList<Body> bodies;

    public Display(int cellSize, int fps, double dt, ArrayList<Body> bodies) {
        super("Gravity Simulator");

        this.cellSize = cellSize;
        this.fps = fps;
        this.dt = dt;
        this.bodies = bodies;
        frameTimer = new Timer(1000 / fps, this);
        mainPanel = new MainPanel(cellSize, dt, bodies);

        add(mainPanel);
        frameTimer.setActionCommand("frame");
        frameTimer.start();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("frame")) {
            mainPanel.update();
            mainPanel.repaint();
        }
    }
}
