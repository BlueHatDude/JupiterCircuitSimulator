package jupiter.components;

/**
 * Wire
 */
public class Wire extends JCS_Component {
    
    public Wire(Orientation orientation) {
        super(orientation);
    }

    @Override
    public String toString() {
        return "Wire facing " + this.getOrientation().name();
    }

}
