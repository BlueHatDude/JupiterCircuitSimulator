package jupiter.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * ComponentSelector
 */
public class ComponentSelector extends JDialog {

    public ComponentSelector(JFrame parent) {
        super(parent, "Select a Component");
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
