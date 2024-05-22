import javax.swing.*;
import java.awt.*;

import jupiter.ui.*;

public class Main {

    private static final ComponentBoard componentBoard = new ComponentBoard(10, 10);

    private static final JPanel toolbar = new JPanel(new FlowLayout());
    private static final JPanel componentBoardContainer = new JPanel(new GridLayout(
            componentBoard.getRows(),
            componentBoard.getColumns()));
    private static final JButton[] buttons = new JButton[100];
    private static final JPanel infobar = new JPanel(new FlowLayout());

    public static void main(String[] args) {

        /* frame initialization */
        JFrame frame = new JFrame("Jupiter Circuit Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        /* toolbar */
        toolbar.setPreferredSize(new Dimension(frame.getWidth(), 50));
        toolbar.setBackground(new Color(0xFF0000));

        /* component board container */
        componentBoardContainer.setPreferredSize(new Dimension(600, frame.getHeight()));
        componentBoardContainer.setBackground(new Color(0x00FF00));

        /* component board buttons */
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(0xFF00FF));
            buttons[i].addActionListener(new GridSpaceHandler(buttons[i], i));
            componentBoardContainer.add(buttons[i]);
        }
        
        /* information bar */
        infobar.setPreferredSize(new Dimension(200, frame.getHeight()));
        infobar.setBackground(new Color(0x0000FF));

        /* adding components */
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(componentBoardContainer, BorderLayout.CENTER);
        frame.add(infobar, BorderLayout.EAST);
        frame.setVisible(true);
    }

}
