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

    public GridSpaceHandler(JButton b, int i) {
        this.btn = b;
        this.index = i;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            System.out.println("Choose component at index " + this.index);
        }
    }
    
}
