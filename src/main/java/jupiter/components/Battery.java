package jupiter.components;

import jupiter.utils.Orientation;

/***
 * Standard battery component for Jupiter Circuit Simulator. Voltage
 * can be changed, but the default is 9 V.
*/
public class Battery extends JCS_Component {

    private double voltage;

    /**
     * standard constructor for Battery component
     * 
     * @param voltage the unit is volts
     * @param orientation cardinal direction
     */
    public Battery(double voltage, Orientation orientation) {
        super(orientation);
        this.voltage = voltage;
        this.setType(ComponentType.BATTERY);
    }

    public void setVoltage(double voltage) {
        if (voltage < 0)
            throw new IllegalArgumentException("Voltage cannot be negative");

        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }

    @Override
    public String toString() {
        return this.voltage + " V Battery facing " + this.orientation.name();
    }

}
