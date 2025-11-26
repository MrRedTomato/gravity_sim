import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetPanel extends JPanel implements ActionListener, ChangeListener {
    private JButton planetButton;
    private boolean addPlanet;
    JSlider massSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);
    JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 12);
    int newBodyMass = 0;
    int newBodyRadius = 0;

    public PlanetPanel() {
        planetButton = new JButton("O");
        planetButton.addActionListener(this);
        planetButton.setActionCommand("planet");

        radiusSlider.addChangeListener(this);
        radiusSlider.setMajorTickSpacing(5);
        radiusSlider.setMinorTickSpacing(1);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);

        massSlider.addChangeListener(this);
        massSlider.setMajorTickSpacing(200);
        massSlider.setMinorTickSpacing(10);
        massSlider.setPaintTicks(true);
        massSlider.setPaintLabels(true);

        addPlanet = false;

        add(radiusSlider);
        add(planetButton);
        add(massSlider);

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
    public double getNewBodyMass() {
        return 1.0 * newBodyMass;
    }
    public double getNewBodyRadius() {
        return 1.0 * newBodyRadius;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("planet")) {
            addPlanet = true;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (source.equals(massSlider)) {
            newBodyMass = source.getValue();
        }
        else if (source.equals(radiusSlider)) {
            newBodyRadius = source.getValue();
        }
    }
}
