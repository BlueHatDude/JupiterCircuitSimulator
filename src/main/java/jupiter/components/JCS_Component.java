// package jupiter.components;
package jupiter.components;

import jupiter.utils.Orientation;

/**
 * The JCS_Component class is the base class that all components of
 * Jupiter Circuit Simulator inherit. 
 */
public abstract class JCS_Component {

    public enum ComponentType {
        BATTERY,
        WIRE,
        RESISTOR,
        LED 
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
