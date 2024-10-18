package jupiter.components;

import java.util.ArrayList;

import jupiter.components.JCS_Component.ComponentType;
import jupiter.utils.Orientation;
import jupiter.utils.Position;

/**
 * The ComponentBoard class is used to store the current state and position of all components.
 * Backend representation of GUI board. 
 */
public class ComponentBoard {

    private final int rows = 10;
    private final int columns = 10;
    private JCS_Component[] components = new JCS_Component[rows * columns];
    private ArrayList<Position> batteries = new ArrayList<>();

    /**
     * Sets the component in component board at `position` to `component`.
     * Note that this method does not perform a deep copy of the of object.
     * 
     * @param position
     * @param component
     */
    public void setComponentAt(Position position, JCS_Component component) throws ArrayIndexOutOfBoundsException {        
        int row = position.getRow();
        int column = position.getColumn();

        if ((row < 0) || (row >= this.rows))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid row");
        if ((column < 0) || (column >= this.columns))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid column");
        
        int index = this.index2DtoIndex1D(position);
        this.components[index] = component;

        if (component.getType() == ComponentType.BATTERY) {
            batteries.add(position);
        }
    }

    /**
     * Sets the component at `row` and `column` to `component`.
     * Note that this method does not perform a deep copy. 
     * 
     * @param row
     * @param column
     * @param component
     * @throws ArrayIndexOutOfBoundsException
     */
    public void setComponentAt(int row, int column, JCS_Component component) throws ArrayIndexOutOfBoundsException {
        if ((row < 0) || (row >= this.rows))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid row");
        if ((column < 0) || (column >= this.columns))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid column");

        int index = this.index2DtoIndex1D(row, column);
        this.components[index] = component;

        if (component.getType() == ComponentType.BATTERY) {
            batteries.add(new Position(row, column));
        }
    }
    
    /**
     * @return number of rows in ComponentBoard.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * @return number of columns in ComponentBoard.
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * @return list of positions of every battery in ComponentBoard
     */
    public ArrayList<Position> getBatteries() {
        return this.batteries;
    }

    /**
     * @param position
     * @return a reference to the component at `position`.
     * @throws ArrayIndexOutOfBoundsException if position falls outside of ComponentBoard
     */
    public JCS_Component getComponentAt(Position position) throws ArrayIndexOutOfBoundsException {
        int row = position.getRow();
        int column = position.getColumn();

        if ((row < 0) || (row >= this.rows))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid row");
        if ((column < 0) || (column >= this.columns))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid column");

        int index = this.index2DtoIndex1D(position);
        return this.components[index];
    }

    /**
     * @param row
     * @param column
     * @return a reference to component at `row` and `column`.
     * @throws ArrayIndexOutOfBoundsException if position falls outside of ComponentBoard
     */
    public JCS_Component getComponentAt(int row, int column) throws ArrayIndexOutOfBoundsException {
        if ((row < 0) || (row >= this.rows))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid row");
        if ((column < 0) || (column >= this.columns))
            throw new ArrayIndexOutOfBoundsException("Trying to access invalid column");
        
        int index = this.index2DtoIndex1D(row, column);
        return this.components[index];
    }

    /**
     * @param orientation
     * @param position
     * @return a reference to the component in front of the component at `position` given
     * the component's orientation. 
     */
    public JCS_Component getComponentTo(Orientation orientation, Position position) {
        Position newPosition = position.getPositionTo(orientation, this.getRows(), this.getColumns());

        JCS_Component component = this.getComponentAt(newPosition);
        return component;
    }

    /**
     * @param row
     * @param column
     * @return true if component at `row`, `column` exists 
     */
    public boolean componentExistsAt(int row, int column) {
        int index = index2DtoIndex1D(row, column);
        return (this.components[index] != null);
    }

    /**
     * @param orientation
     * @param position
     * @return true if component exists in front of the component at `position` given
     * the component's orientation. 
     */
    public boolean componentExistsTo(Orientation orientation, Position position) {
        Position newPosition = position.getPositionTo(orientation, this.getRows(), getColumns());

        if (this.getComponentAt(newPosition) == null) {
            return false;
        } else {
            return true;
        }

    }

    private boolean isValidPosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        
        if ((row < 0) || (column < 0)) {
            return false;
        } else if ((row >= this.getRows()) || (column >= this.getColumns())) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidPosition(int row, int column) {        
        if ((row < 0) || (column < 0)) {
            return false;
        } else if ((row >= this.getRows()) || (column >= this.getColumns())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param index index of component in a 1D array of componenets.
     * @return corresponding index in 2D array of components.
     */
    public Position index1DtoIndex2D(int index) {
        Position pos = new Position(index / this.columns, index % columns);
        return pos;
    }

    /**
     * @param position
     * @return corresponding 1D index of `position`.
     */
    public int index2DtoIndex1D(Position position) {
        return (position.getRow() * this.columns) + position.getColumn();
    }

    /**
     * @param row
     * @param column
     * @return corresponding 1D index of `position`.
     */
    public int index2DtoIndex1D(int row, int column) {
        return (row * this.columns) + column;
    }

}
