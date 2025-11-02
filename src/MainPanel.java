import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Field field;
    int cellSize, fps;

    public MainPanel(int cellSize, int fps, Field field) {
        this.field = field;
        this.cellSize = cellSize;
        this.fps = fps;

        setPreferredSize(new Dimension(500, 500));
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
            g.fillArc((int) (mass.getX() * cellSize), (int) (mass.getY() * cellSize), cellSize, cellSize, 0, 360);
        }
    }
}
