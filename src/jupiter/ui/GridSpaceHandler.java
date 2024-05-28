package jupiter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
        /**
         * TODO change componentBoard to reflect component chosen
         */
        if (e.getSource() == this.btn) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this.btn);
            new ComponentSelector(parentFrame);
        }
    }
    
}
