package jupiter.utils;

/**
 * Position
 */
public class Position {

    private int row;
    private int column;

    public Position() {}

    public Position(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
    }
    
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setPosition(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
    }

}
