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
    
    public enum ComponentType {
        BATTERY,
        WIRE,
        RESISTOR
    };

    private Orientation orientation;
    private ComponentType type;

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }

}
