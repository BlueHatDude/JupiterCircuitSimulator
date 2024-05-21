package jupiter.components;

/**
 * Wire
 */
public class Wire extends JCS_Component {

    public Wire(Orientation orientation) {
        this.setOrientation(orientation);
    }

    @Override
    public String toString() {
        return "Wire facing " + this.getOrientation().name(); 
    }

}
