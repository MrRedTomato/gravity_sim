import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    MainPanel mainPanel;
    int cellSize, fps;
    Field field;
    Timer timer;

    public Display(int cellSize, int fps, Field field) {
        super("Gravity Simulator");

        this.cellSize = cellSize;
        this.fps = fps;
        this.field = field;
        timer = new Timer(1000 / fps, this);
        mainPanel = new MainPanel(cellSize, fps, field);

        add(mainPanel);
        timer.setActionCommand("timer");

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("timer")) {
            mainPanel.updateState();
            mainPanel.repaint();
        }
    }
}
