import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import jupiter.components.Battery;
import jupiter.components.JCS_Component;
import jupiter.components.Resistor;
import jupiter.components.Wire;
import jupiter.components.JCS_Component.Orientation;
import jupiter.ui.*;

public class Main {

    /* global constants */
    /** color palette */

    /* back-end ui */
    private static final ComponentBoard components = new ComponentBoard(10, 10);
    private static final int cbRows = components.getRows();
    private static final int cbColumns = components.getColumns();

    /* front-end ui */
    private static final JPanel toolbar = new JPanel(new FlowLayout());
    private static final JPanel componentBoardContainer = new JPanel(new GridLayout(
            cbRows,
            cbColumns,
            5, 5));
    private static final int numButtons = cbRows * cbColumns;
    private static final JButton[] buttons = new JButton[numButtons];
    private static final JPanel infoPanel = new JPanel(new FlowLayout());

    public static void main(String[] args) {

        /* DEBUGGING */
        Battery battery = new Battery(9.0, Orientation.EAST);
        components.setComponentAt(battery, 0, 0);
        components.setComponentAt(new Wire(Orientation.SOUTH), 0, 1);
        components.setComponentAt(new Resistor((int) 1e3, Orientation.WEST), 1, 1);
        components.setComponentAt(new Wire(Orientation.NORTH), 1, 0);

        /* frame initialization */
        JFrame frame = new JFrame("Jupiter Circuit Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());

        /* toolbar */
        toolbar.setPreferredSize(new Dimension(frame.getWidth(), 50));
        toolbar.setBackground(new Color(0xFF0000));

        /* component board container */
        componentBoardContainer.setPreferredSize(new Dimension(600, frame.getHeight()));
        componentBoardContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        componentBoardContainer.setBackground(new Color(0x00FF00));

        /* component board buttons */
        int btnsIndex = 0;

        for (int r = 0; r < cbRows; r++) {
            for (int c = 0; c < cbColumns; c++) {
                btnsIndex = ComponentBoard.index2DtoIndex1D(r, c, cbColumns);
                buttons[btnsIndex] = new JButton();
                buttons[btnsIndex].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                buttons[btnsIndex].setBackground(new Color(0xFF00FF));
                buttons[btnsIndex].setOpaque(true);
                buttons[btnsIndex].setBorderPainted(false);
                buttons[btnsIndex].setForeground(new Color(0x000000));
                buttons[btnsIndex].addActionListener(
                        new GridSpaceHandler(buttons[btnsIndex], btnsIndex, components)
                );

                if (components.getComponentAt(r, c) != null) {
                    char symbol = JCS_Component.typeToChar(components.getComponentAt(r, c).getType());
                    System.out.println("Component '" + symbol + "' at (" + r + ", " + c + ")");
                    buttons[btnsIndex].setText(Character.toString(symbol));
                }

                componentBoardContainer.add(buttons[btnsIndex]);
            }
        }

        /* information bar */
        infoPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        infoPanel.setBackground(new Color(0x0000FF));

        /* adding components */
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(componentBoardContainer, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }

}
