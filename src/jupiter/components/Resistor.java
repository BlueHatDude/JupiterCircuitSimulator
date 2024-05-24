package jupiter.components;

/**
 * Resistor
 */
public class Resistor extends JCS_Component {

    private int resistance;

    public Resistor(Orientation orientation) {
        this.setType(ComponentType.RESISTOR);
        this.setOrientation(orientation);
    }
    
    public Resistor(int resistance, Orientation orientation) {
        this.setType(ComponentType.RESISTOR);
        this.setOrientation(orientation);
        this.resistance = resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return  this.resistance + " Ω  Ressitor facing " + this.getOrientation().name();
    }

}
