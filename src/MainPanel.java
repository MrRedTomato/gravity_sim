import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Field field;
    int cellSize, fps;

    public MainPanel(int cellSize, int fps, Field field) {
        this.field = field;
        this.cellSize = cellSize;
        this.fps = fps;

        setPreferredSize(new Dimension(700, 700));
        setBackground(new Color(255, 230, 230));
    }

    public void updateState() {
        field.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);

        for (Mass mass : field.getObjects()) {
            g.fillArc((int) ((mass.getX() - mass.getRadius()) * cellSize), (int) ((mass.getY() - mass.getRadius()) * cellSize), (int) (cellSize * mass.getRadius()), (int) (cellSize * mass.getRadius()), 0, 360);
        }
    }
}
