package jupiter.components;

/**
 * Resistor
 */
public class Resistor extends JCS_Component {

    private int resistance;

    public Resistor(Orientation orientation) {
        this.orientation = orientation;
    }
    
    public Resistor(int resistance, Orientation orientation) {
        this.resistance = resistance;
        this.orientation = orientation;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return  this.resistance + " Ω  Ressitor facing " + this.orientation.name();
    }

}
