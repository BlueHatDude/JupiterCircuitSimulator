package jupiter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import jupiter.components.JCS_Component;

/**
 * GridSpaceHandler
 */
public class GridSpaceHandler implements ActionListener {

    private JButton btn;
    private int index;
    private ComponentBoard cb;
    private JButton[] btns;

    public GridSpaceHandler(JButton b, int i, ComponentBoard cb, JButton[] btns) {
        this.btn = b;
        this.index = i;
        this.cb = cb;
        this.btns = btns;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn) {

            int[] coordinates = ComponentBoard.index1DtoIndex2D(index, this.cb.getColumns());
            JCS_Component component = this.cb.getComponentAt(coordinates[0], coordinates[1]);

            if (component == null) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this.btn);
                ComponentSelector selector = new ComponentSelector(parentFrame);
                selector.addWindowListener(new SelectorCloseHandler(selector, this.cb, this.index, this.btns));     
            } else {
                String[] optionStrings = {"Change Component", "Change Component Properties"};
                int response = JOptionPane.showOptionDialog(null,
                    "Choose An Option",
                    "Option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    optionStrings,
                    optionStrings[0]
                );

                if (response == 0) {
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this.btn);
                    ComponentSelector selector = new ComponentSelector(parentFrame);
                    selector.addWindowListener(new SelectorCloseHandler(selector, this.cb, this.index, this.btns));     
                } else if (response == 1) {
                    new ComponentAlterer(component);
                }
            }
        }
    }
    
}
 