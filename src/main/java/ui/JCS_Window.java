package ui;

import javax.swing.JFrame;
import java.awt.Color;

/**
 * JCS_Window
 */
public class JCS_Window {

    public JCS_Window() {
        JFrame frame = new JFrame();
        frame.setTitle("Jupiter Circuit Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(Palette.BACKGROUND));
        frame.setVisible(true);
    }
    
}
