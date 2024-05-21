import jupiter.components.*;
import jupiter.components.JCS_Component.Orientation;

public class Main {

    public static void main(String[] args) {
        Battery battery = new Battery(9.0, Orientation.EAST);
        Wire wire = new Wire(Orientation.NORTH);
        Resistor resistor = new Resistor(1000, Orientation.SOUTH);

        System.out.println(battery);
        System.out.println(wire);
        System.out.println(resistor);
    }
    
}
