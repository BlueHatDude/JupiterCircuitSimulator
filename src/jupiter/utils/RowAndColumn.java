package jupiter.utils;

/**
 * RowAndColumn
 */
public class RowAndColumn {

    private int row;
    private int column;

    public RowAndColumn(int row, int column) {
        this.row = row;
        this.column = column;
    }
 
    public void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

}
