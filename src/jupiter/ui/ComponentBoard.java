package jupiter.ui;

import jupiter.components.*;

public class ComponentBoard {

    private int rows;
    private int columns;
    JCS_Component[][] components;

    public ComponentBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.components = new JCS_Component[rows][columns];
    }

    public void setComponentAt(Battery comp, int row, int column) {
        this.components[row][column] = new Battery(
            comp.getVoltage(),
            comp.getOrientation()
        );
    }

    public void setComponentAt(Resistor comp, int row, int column) {
        this.components[row][column] = new Resistor(comp.getResistance(), comp.getOrientation());
    }

    public void setComponentAt(Wire comp, int row, int column) {
        this.components[row][column] = new Wire(comp.getOrientation());
    }

    public JCS_Component getComponentAt(int row, int column) {
        return this.components[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public JCS_Component[][] getComponents() {
        return components;
    }

    public static int index2DtoIndex1D(int row, int column, int ncolumns) {

        return (row * ncolumns) + column;
        
    }

}
