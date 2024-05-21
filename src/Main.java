import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import jupiter.components.*;
import jupiter.ui.*;

public class Main {

    private static final ComponentBoard componentBoard = new ComponentBoard(10, 10);
    private static final JPanel toolbar = new JPanel(new FlowLayout());
    private static final JPanel components = new JPanel(new GridLayout());
    private static final JPanel infobar = new JPanel(new FlowLayout());

    public static void main(String[] args) { 
        
        JFrame frame = new JFrame("Jupiter Circuit Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        frame.setVisible(true);
    }
    
}
