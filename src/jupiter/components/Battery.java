package jupiter.components;

public class Battery extends JCS_Component {

    private double voltage;

    public Battery(Orientation orientation) {
        this.setOrientation(orientation);
        this.setType(ComponentType.BATTERY);
        this.voltage = 0;
    }

    public Battery(double voltage, Orientation orientation) {
        this.setOrientation(orientation);
        this.setType(ComponentType.BATTERY);
        this.voltage = voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }

    @Override
    public String toString() {
        return this.voltage + " V Battery facing " + this.getOrientation().name();
    }

}
