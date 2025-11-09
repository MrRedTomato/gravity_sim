import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    JButton stepButton = new JButton();

    public ButtonPanel() {
        stepButton.addActionListener(this);

        setPreferredSize(new Dimension(700, 50));
        setBackground(new Color(150, 150, 150));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
