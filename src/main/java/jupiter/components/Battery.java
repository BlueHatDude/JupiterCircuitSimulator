package jupiter.components;

public class Battery extends JCS_Component {

    private double voltage;

    public Battery(double voltage, Orientation orientation) {
        super(orientation);
        this.voltage = voltage;
        this.setType(ComponentType.BATTERY);
    }

    public void setVoltage(double voltage) {
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
