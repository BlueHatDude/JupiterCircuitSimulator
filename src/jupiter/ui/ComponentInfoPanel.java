package jupiter.ui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jupiter.components.Battery;
import jupiter.components.JCS_Component;
import jupiter.components.Resistor;
import jupiter.components.JCS_Component.ComponentType;
import jupiter.components.JCS_Component.Orientation;

/**
 * ComponentInfoPanel
 */
public class ComponentInfoPanel extends JPanel {

    // private String compName;
    // private String compType;
    private JLabel compNameLabel = new JLabel("JCS Component");
    private JLabel compTypeLabel = new JLabel("Component Type");
    private JLabel compOrienatationLabel = new JLabel("Orientation");
    /**
     * dispalys voltage, resistance, etc.
     */
    private JLabel compValueLabel = new JLabel("Value: N/A");

    public ComponentInfoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.compNameLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.compTypeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.compOrienatationLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.compValueLabel.setBorder(new EmptyBorder(20, 0, 20, 0)); 
    

        this.compNameLabel.setForeground(new Color(0));
        this.compTypeLabel.setForeground(new Color(0));
        this.compOrienatationLabel.setForeground(new Color(0));
        this.compValueLabel.setForeground(new Color(0));

        this.add(compNameLabel);
        this.add(compTypeLabel);
        this.add(compOrienatationLabel);
        this.add(compValueLabel);
    }

    public void updateInfo(JCS_Component comp) {
        if (comp == null)
            return;

        Orientation orientation = comp.getOrientation();
        compOrienatationLabel.setText("Orientation: " + orientation.name());

        ComponentType type = comp.getType();
        compTypeLabel.setText("Type: " + comp.getType().name());

        if (type == ComponentType.BATTERY) {
            compValueLabel.setText("Voltage: " + ((Battery) comp).getVoltage());
        } else if (type == ComponentType.RESISTOR) {
            compValueLabel.setText("Resistance: " + ((Resistor) comp).getResistance());
        } else {
            compValueLabel.setText("Value: N/A");
        }
    } 

}
