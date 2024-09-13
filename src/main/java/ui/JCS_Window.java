package ui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 * JCS_Window
 */
public class JCS_Window extends JFrame {

    public JCS_Window() {
        this.setTitle("Jupiter Circuit Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(Palette.WINDOW_BACKGROUND));

        Toolbar toolbar = new Toolbar();
        InfoPanel infoPanel = new InfoPanel();

        this.setLayout(new BorderLayout());
        this.add(toolbar, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.EAST);

        this.setVisible(true);
    }

}
