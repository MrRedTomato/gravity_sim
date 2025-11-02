import javax.swing.*;

public class Display extends JFrame {
    MainPanel mainPanel = new MainPanel();
    int cellSize, fps;
    Field field;
    public Display(int cellSize, int fps, Field field) {
        super("Gravity Simulator");

        this.cellSize = cellSize;
        this.fps = fps;
        this.field = field;

        add(mainPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
