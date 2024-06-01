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
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this.btn);
            ComponentSelector selector = new ComponentSelector(parentFrame);
            // System.err.println("GridSpaceHandler.actionPerformed()");
            // System.err.println(this.btns);
            selector.addWindowListener(new SelectorCloseHandler(selector, this.cb, this.index, this.btns)); 
        }
    }
    
}
