import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

import jupiter.components.*;
import jupiter.components.JCS_Component.Orientation;
import jupiter.components.JCS_Component.ComponentType;
import jupiter.ui.*;

public class Main {

    /* global constants */
    /** color palette */
    private static final int BACKGROUND_COLOR = 0xFDD1C4;
    private static final int TOOLBAR_COLOR = 0xB76E2F;
    private static final int CB_GRID_SPACE_COLOR = 0xAC6A32;
    private static final int INFO_PANEL_COLOR = 0x883D07;

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
    private static final int numButtons = (cbRows * cbColumns);
    private static final JButton[] buttons = new JButton[numButtons];
    private static final JPanel infoPanel = new JPanel(new FlowLayout());

    public static void main(String[] args) {

        /* DEBUGGING */
        // Battery battery = new Battery(9.0, Orientation.EAST);
        // components.setComponentAt(battery, 0, 0);
        // components.setComponentAt(new Wire(Orientation.SOUTH), 0, 1);
        // components.setComponentAt(new Resistor((int) 1e3, Orientation.WEST), 1, 1);
        // components.setComponentAt(new Wire(Orientation.NORTH), 1, 0);

        /* frame initialization */
        JFrame frame = new JFrame("Jupiter Circuit Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLayout(new BorderLayout());

        /* toolbar */
        toolbar.setPreferredSize(new Dimension(frame.getWidth(), 80));
        toolbar.setBackground(new Color(TOOLBAR_COLOR));

        /* component board container */
        componentBoardContainer.setPreferredSize(new Dimension(600, frame.getHeight()));
        componentBoardContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        componentBoardContainer.setBackground(new Color(BACKGROUND_COLOR));

        /* component board buttons */
        int btnsIndex = 0;
        for (int r = 0; r < cbRows; r++) {
            for (int c = 0; c < cbColumns; c++) {
                btnsIndex = ComponentBoard.index2DtoIndex1D(r, c, cbColumns);
                buttons[btnsIndex] = new JButton();
                buttons[btnsIndex].setFocusable(false);
                buttons[btnsIndex].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                buttons[btnsIndex].setBackground(new Color(CB_GRID_SPACE_COLOR));
                buttons[btnsIndex].setOpaque(true);
                buttons[btnsIndex].setBorderPainted(false);
                buttons[btnsIndex].setForeground(new Color(0x000000));

                buttons[btnsIndex].addActionListener(
                        new GridSpaceHandler(buttons[btnsIndex], btnsIndex, components, buttons)
                );
                componentBoardContainer.add(buttons[btnsIndex]);
            }
        }

        /* information bar */
        infoPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        infoPanel.setBackground(new Color(INFO_PANEL_COLOR));

        /* adding GUI components */
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(componentBoardContainer, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }

}
