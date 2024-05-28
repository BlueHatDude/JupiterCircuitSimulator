package jupiter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * ComponentSelectHandler
 */
public class ComponentSelectHandler implements ActionListener {

    private JButton btn;
    private ComponentSelectResponse response;

    public ComponentSelectHandler(JButton b, ComponentSelectResponse r) {
        this.btn = b;
        this.response = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn) {
            this.response.setResponse(this.btn.getText());
            JDialog parentDialog = (JDialog) SwingUtilities.getWindowAncestor(btn);
            parentDialog.dispatchEvent(new WindowEvent(parentDialog, WindowEvent.WINDOW_CLOSING));
        }
    }
    
}
