import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    int cellSize;
    double dt;
    ArrayList<Body> bodies;

    public MainPanel(int cellSize, double dt, ArrayList<Body> bodies) {
        this.cellSize = cellSize;
        this.dt = dt;
        this.bodies = bodies;

        setPreferredSize(new Dimension(700, 700));
        setBackground(new Color(255, 200, 200));
    }

    public void update() {
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).update(bodies, dt);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);

        for (Body body : bodies) {
            g.fillArc(
                (int) ((body.getPosition().getX() - body.getRadius()) * cellSize),
                (int) ((body.getPosition().getY() - body.getRadius()) * cellSize),
                (int) (cellSize * body.getRadius() * 2),
                (int) (cellSize * body.getRadius() * 2),
                0,
                360
            );
        }
    }
}
