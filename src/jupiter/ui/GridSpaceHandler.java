package jupiter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;

/**
 * GridSpaceHandler
 */
public class GridSpaceHandler implements ActionListener {

    private JButton btn;
    private int index;
    private ComponentBoard cb;

    public GridSpaceHandler(JButton b, int i, ComponentBoard cb) {
        this.btn = b;
        this.index = i;
        this.cb = cb;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this.btn);
            ComponentSelector selector = new ComponentSelector(parentFrame);

            ComponentType type = JCS_Component.charToType(selector.getResponseString().charAt(0));
            JCS_Component component = JCS_Component.typeToDefaultComponent(type);
            int[] coordinates = ComponentBoard.index1DtoIndex2D(this.index, this.cb.getColumns());
            this.cb.setComponentAt(component, coordinates[0], coordinates[1]);
            System.out.printf("Set %s at (%d, %d) \n", component, coordinates[0], coordinates[1]);
        }
    }
    
}
