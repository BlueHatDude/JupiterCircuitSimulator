package jupiter.components;


abstract public class JCS_Component {

    /**
     * where front of component is facing
     */
    public enum Orientation {
        NORTH,
        EAST,
        SOUTH,
        WEST
    };
    
    Orientation orientation;

}
