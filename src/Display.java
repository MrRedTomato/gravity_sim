import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    MainPanel mainPanel;
    int cellSize, fps;
    Field field;
    Timer frameTimer;

    public Display(int cellSize, int fps, Field field) {
        super("Gravity Simulator");

        this.cellSize = cellSize;
        this.fps = fps;
        this.field = field;
        frameTimer = new Timer(1000 / fps, this);
        mainPanel = new MainPanel(cellSize, fps, field);

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
            field.update();
            mainPanel.repaint();
        }
    }
}
