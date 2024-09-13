package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Toolbar
 */
public class Toolbar extends JPanel {

    public Toolbar() {
        this.setBackground(new Color(Palette.TOOLBAR));
        this.setPreferredSize(new Dimension(100, 75));
    }
    
}
