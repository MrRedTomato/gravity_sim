import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Display extends JFrame implements ActionListener {
    MainPanel mainPanel;
    ButtonPanel buttonPanel;
    PlanetPanel planetPanel;
    int cellSize, fps;
    double dt;
    Timer frameTimer;
    ArrayList<Body> bodies;
    JButton stepButton = new JButton("|▶");
    JButton pause = new JButton("||");
    JButton play = new JButton("▶");
    JButton reset = new JButton("↺");

    public Display(int cellSize, int fps, double dt, ArrayList<Body> bodies) {
        super("Gravity Simulator");

        this.cellSize = cellSize;
        this.fps = fps;
        this.dt = dt;
        this.bodies = bodies;
        frameTimer = new Timer(1000 / fps, this);
        mainPanel = new MainPanel(cellSize, dt, bodies);
        buttonPanel = new ButtonPanel();
        planetPanel = new PlanetPanel();

        play.addActionListener(this);
        pause.addActionListener(this);
        stepButton.addActionListener(this);
        reset.addActionListener(this);

        buttonPanel.add(play);
        buttonPanel.add(pause);
        buttonPanel.add(stepButton);
        buttonPanel.add(reset);

        add(mainPanel);
        add(buttonPanel, BorderLayout.SOUTH);
        add(planetPanel, BorderLayout.NORTH);
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
            if (planetPanel.shouldAddPlanet()) {
                mainPanel.setAddPlanet(true);
                planetPanel.addedPlanet();
            }
            mainPanel.update();
            mainPanel.repaint();
        }
        if (e.getActionCommand().equals("||")) {
            frameTimer.stop();
        }
        if (e.getActionCommand().equals("▶")) {
            frameTimer.start();
        }
        if (e.getActionCommand().equals("|▶")) {
            mainPanel.update();
            mainPanel.repaint();
        }
        if (e.getActionCommand().equals("↺")) {
            bodies.clear();
        }
    }
}
