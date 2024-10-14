package ui.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import ui.general.Palette;

/**
 * Toolbar
 */
public class Toolbar extends JPanel {

    public Toolbar() {
        this.setBackground(new Color(Palette.TOOLBAR));
        this.setPreferredSize(new Dimension(100, 75));
    }
    
}
