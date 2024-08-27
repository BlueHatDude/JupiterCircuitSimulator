package jupiter.components;

public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Orientation getOppositeOrientation(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                return null;
        } 
    }
}