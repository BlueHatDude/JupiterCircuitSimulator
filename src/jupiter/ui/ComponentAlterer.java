package jupiter.ui;

import javax.swing.JDialog;

import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;

/**
 * ComponentAlterer
 */
public class ComponentAlterer extends JDialog {
    
    public ComponentAlterer(JCS_Component comp) {
        ComponentType type = comp.getType();
        
        if (type == ComponentType.BATTERY) {

        } else if (type == ComponentType.RESISTOR) {

        }
        
    }
    
}
