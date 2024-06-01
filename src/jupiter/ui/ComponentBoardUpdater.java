package jupiter.ui;

import javax.swing.JButton;

import jupiter.components.JCS_Component;

/**
 * UpdateComponentBoard
 */
public class ComponentBoardUpdater {

    public static void updateComponentBoard(ComponentBoard cb, JButton[] btns) {
        int cbRows = cb.getRows();
        int cbColumns = cb.getColumns();

        // System.err.println("Entered | ComponentBoardUpdater.updateComponentBoard()");

        for (int r = 0; r < cbRows; r++) {
            for (int c = 0; c < cbColumns; c++) {
                if (cb.getComponentAt(r, c) != null) {
                    // System.err.println("Updated | ComponentBoardUpdater.updateComponentBoard()");
                    // System.err.println("Component Selected: " + cb.getComponentAt(r, c));
                    // System.err.println("Buttons Length: " + btns.length);
                    int btnsIndex = ComponentBoard.index2DtoIndex1D(r, c, cbColumns);
                    char symbol = JCS_Component.typeToChar(cb.getComponentAt(r, c).getType());
                    btns[btnsIndex].setText(Character.toString(symbol));
                    // System.err.println("Symbol: " + symbol);
                }
            }
        }
    }
    
}
