import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetPanel extends JPanel implements ActionListener {
    private JButton planetButton;
    private boolean addPlanet;

    public PlanetPanel() {
        planetButton = new JButton("O");
        planetButton.addActionListener(this);
        planetButton.setActionCommand("planet");

        addPlanet = false;

        add(planetButton);

        setPreferredSize(new Dimension(700, 50));
        setBackground(new Color(150, 150, 150));
        setVisible(true);
    }

    public boolean shouldAddPlanet() {
        return addPlanet;
    }
    public void addedPlanet() {
        addPlanet = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("planet")) {
            addPlanet = true;
        }
    }
}
