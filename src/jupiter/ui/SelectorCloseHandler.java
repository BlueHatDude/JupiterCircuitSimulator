package jupiter.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;

/**
 * SelectorCloseHandler
 */
public class SelectorCloseHandler implements WindowListener {

    ComponentSelector selector;
    ComponentBoard cb;
    int index;
    JButton[] buttons;

    public SelectorCloseHandler(ComponentSelector s, ComponentBoard cb, int index, JButton[] btns) {
        this.selector = s;
        this.cb = cb;
        this.index = index;
        this.buttons = btns;
    }
    

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {
        if (e.getSource() == this.selector) {
            String response = this.selector.getResponseString();
            ComponentType type = JCS_Component.charToType(response.charAt(0));
            JCS_Component component = JCS_Component.typeToDefaultComponent(type);
            int[] coordinates = ComponentBoard.index1DtoIndex2D(this.index, this.cb.getColumns());
            this.cb.setComponentAt(component, coordinates[0], coordinates[1]);
            // System.err.println("SelectorCloseHandler.windowClosed()");
            // System.err.printf("Set component %s at (%d, %d) \n", component.toString(), coordinates[0], coordinates[1]);
            // System.err.println("set component " + component + " at " + "(" + coordinates[0] + ", " + coordinates[1] + ")");

            // System.err.println("this.buttons: " + this.buttons);
            ComponentBoardUpdater.updateComponentBoard(this.cb, this.buttons);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

}
