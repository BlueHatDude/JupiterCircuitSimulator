package jupiter.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * ComponentSelector
 */
public class ComponentSelector extends JDialog {

    public ComponentSelector(JFrame parent) {
        /* setting JDialog owner */
        super(parent, "Select a Component");
        
        /* configuration */
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setSize(450, 450);
        this.setResizable(false);
        this.setVisible(true);

        /* adding options */
        String[] componentNames = {"Battery", "Resistor", "Wire"};
        for (String name : componentNames) {
            JButton button = new JButton(name);
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(100, 100));
            this.add(button);
        }
    }

}
