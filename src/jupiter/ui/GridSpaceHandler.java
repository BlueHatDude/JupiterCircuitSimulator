package jupiter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
        if (e.getSource() == btn) {
            System.out.println("Choose component at index " + this.index);
        }
    }
    
}
