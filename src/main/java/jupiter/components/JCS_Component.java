// package jupiter.components;
package jupiter.components;
 
/**
 * JCS_Component
 */
public abstract class JCS_Component {

    public enum ComponentType {
        BATTERY,
        WIRE,
        RESISTOR,
        LED 
    }; 

    public enum Orientation {
        NORTH,
        EAST,
        SOUTH,
        WEST
    };

    ComponentType type;
    Orientation orientation;

    public JCS_Component(Orientation orientation) {
        this.setOrientation(orientation);
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
