import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
    private int cellSize;
    private double dt;
    private double x, y, clickX, clickY, xInit, yInit;
    private boolean addPlanet;
    private Body newBody;
    private ArrayList<Body> bodies;

    public MainPanel(int cellSize, double dt, ArrayList<Body> bodies) {
        this.cellSize = cellSize;
        this.dt = dt;
        this.bodies = bodies;
        addPlanet = false;
        newBody = new Body(0, 0, 0, 0, dt);
        x = 0;
        y = 0;
        clickX = 0;
        clickY = 0;
        xInit = 0;
        yInit = 0;

        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(700, 700));
        setBackground(new Color(255, 200, 200));
    }

    public void update() {
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).update(bodies);
        }
    }
    public void setAddPlanet(boolean addPlanet) {
        this.addPlanet = addPlanet;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);

        for (Body body : bodies) {
            g.fillArc(
                (int) ((body.getPosition().getX() - body.getRadius()) * cellSize + x),
                (int) ((body.getPosition().getY() - body.getRadius()) * cellSize + y),
                (int) (cellSize * body.getRadius() * 2),
                (int) (cellSize * body.getRadius() * 2),
                0,
                360
            );
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickX = e.getX() - x;
        clickY = e.getY() - y;
        xInit = e.getX();
        yInit = e.getY();
        newBody.setPosition(new Vector(clickX / cellSize, clickY / cellSize));
        newBody.setRadius(1);
        newBody.setMass(1);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (addPlanet) {
            newBody.setVel(new Vector((e.getX() - xInit) / cellSize, (e.getY() - yInit) / cellSize));
        }
        else {
            x = e.getX() - clickX;
            y = e.getY() - clickY;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (addPlanet) {
            bodies.add(newBody);
            newBody = new Body(0, 0, 0, 0, dt);
            addPlanet = false;
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
