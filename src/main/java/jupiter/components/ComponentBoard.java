package jupiter.components;

import jupiter.utils.Position;

/**
 * ComponentBoard
 */
public class ComponentBoard {

    private final int rows = 10;
    private final int columns = 10;
    private JCS_Component[] components = new JCS_Component[rows * columns];
    
    public void setComponentAt(Position position, JCS_Component component) {
        int index = this.index2DtoIndex1D(position);
        this.components[index] = component;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public JCS_Component getComponentAt(Position position) {
        if ((position.getRow() < 0) || (position.getColumn() < 0)) {
            return null;
        }

        if ((position.getRow() < this.rows) && (position.getColumn() < this.columns)) {
            int index = this.index2DtoIndex1D(position);
            return this.components[index];
        } else {
            return null;
        }
    }
 
    private Position index1DtoIndex2D(int index) {
        Position pos = new Position();
        pos.setColumn(index % columns);
        pos.setRow(index / this.columns);
        return pos;
    }

    private int index2DtoIndex1D(Position position) {
        return (position.getRow() * this.columns) + position.getColumn();
    }

}
