package jupiter.components;

import jupiter.utils.Orientation;
import jupiter.utils.Position;

/**
 * ComponentBoard
 */
public class ComponentBoard {

    private final int rows = 10;
    private final int columns = 10;
    private JCS_Component[] components = new JCS_Component[rows * columns];

    /**
     * sets the component in component board at `position` to `component`
     * note that this method does not do a deep copy of the of object.
     * 
     * @param position
     * @param component
     */
    public void setComponentAt(Position position, JCS_Component component) {
        int index = this.index2DtoIndex1D(position);
        this.components[index] = component;
    }

    public void setComponentAt(int row, int column, JCS_Component component) {
        int index = this.index2DtoIndex1D(row, column);
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

    public JCS_Component getComponentAt(int row, int column) {
        if ((row < 0) || (column < 0)) {
            return null;
        } else if ((row >= this.rows) || (column >= this.columns)) {
            return null;
        } else {
            int index = this.index2DtoIndex1D(row, column);
            return this.components[index];
        }
    }

    public JCS_Component getComponentTo(Orientation orientation, Position position) {
        Position newPosition = position.getPositionTo(orientation, this.getRows(), this.getColumns());
        JCS_Component component = this.getComponentAt(newPosition);
        return component;
    }

    public boolean componentExistsAt(int row, int column) {
        int index = index2DtoIndex1D(row, column);
        return (this.components[index] != null);
    }

    public boolean componentExistsTo(Orientation orientation, Position position) {
        Position newPosition = position.getPositionTo(orientation, this.getRows(), getColumns());

        if (this.getComponentAt(newPosition) == null) {
            return false;
        } else {
            return true;
        }

    }

    public Position index1DtoIndex2D(int index) {
        Position pos = new Position(index / this.columns, index % columns);
        return pos;
    }

    public int index2DtoIndex1D(Position position) {
        return (position.getRow() * this.columns) + position.getColumn();
    }

    public int index2DtoIndex1D(int row, int column) {
        return (row * this.columns) + column;
    }

}
