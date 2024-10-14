package ui.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * InfoPanel
 */
public class InfoPanel extends JPanel {
    
    public InfoPanel() {
        this.setBackground(new Color(Palette.INFO_PANEL));
        this.setPreferredSize(new Dimension(250, 100));
    }

}
