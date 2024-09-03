package jupiter.components;

import jupiter.utils.Orientation;

/**
 * Resistor
 */
public class Resistor extends JCS_Component {

    private double resistance;
    
    public Resistor(int resistance, Orientation orientation) {
        super(orientation);
        this.resistance = resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public double getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return this.getResistance() + " Ω Resistor facing " + this.getOrientation().name();
    }

}
