package jupiter.utils;

/**
 * Position
 */
public class Position {

    private int row;
    private int column;

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

    public void move(Orientation orientation, int rows, int columns) {
        switch (orientation) {
            case NORTH:
                this.row = Validation.constrainInt(this.row - 1, 0, rows - 1);
                break;
            case EAST:
                this.column = Validation.constrainInt(this.column + 1, 0, columns - 1);
                break;
            case SOUTH:
                this.row = Validation.constrainInt(this.row + 1, 0, rows - 1);
                break;
            case WEST:
                this.column = Validation.constrainInt(this.column - 1, 0, columns - 1);
                break;
            default:
                break;
        }
    }

    public Position getPositionTo(Orientation orientation, int rows, int columns) {
        int row = this.row;
        int column = this.column;

        switch (orientation) {
            case NORTH:
                row = Validation.constrainInt(row - 1, 0, rows - 1);
                return new Position(row, column);
            case EAST:
                column = Validation.constrainInt(column + 1, 0, columns - 1);
                return new Position(row, column);
            case SOUTH:
                row = Validation.constrainInt(row + 1, 0, rows - 1);
                return new Position(row, column);
            case WEST:
                column = Validation.constrainInt(column - 1, 0, columns - 1);
                return new Position(row, column);
            default:
                return new Position(-1, -1);
        }
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }

}
