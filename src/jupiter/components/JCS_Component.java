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

    public static char typeToChar(ComponentType type) {
        if (type == null)
            return '\0';
        
        switch (type) {
            case BATTERY:
                return 'B';
            case RESISTOR:
                return 'R';
            case WIRE:
                return 'W';
            default:
                return ' ';
        }
    }

    public static ComponentType charToType(char c) {
        switch (c) {
            case 'B':
                return ComponentType.BATTERY;
            case 'R':
                return ComponentType.RESISTOR;
            case 'W':
                return ComponentType.WIRE;
            default:
                return null;
        }
    }

    public static JCS_Component typeToDefaultComponent(ComponentType type) {
        switch (type) {
            case BATTERY: 
                return new Battery(9.0, Orientation.NORTH);
            case RESISTOR:
                return new Resistor(1000, Orientation.NORTH);
            case WIRE:    
                return new Wire(Orientation.NORTH);
            default:
                return null;
        }
    }

}
