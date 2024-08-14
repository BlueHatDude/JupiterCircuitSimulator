package app;

import jupiter.components.Battery;
import jupiter.components.LED;
import jupiter.components.Resistor;
import jupiter.components.Wire;

import jupiter.components.LED.LED_Color;
import jupiter.components.JCS_Component.Orientation;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Battery battery = new Battery(9.0, Orientation.NORTH);
        Wire wire = new Wire(Orientation.EAST);
        Resistor resistor = new Resistor(1_000, Orientation.SOUTH);
        LED redLED = new LED(LED_Color.RED, Orientation.NORTH);

        System.out.println(battery);
        System.out.println(wire);
        System.out.println(resistor);
        System.out.println(redLED);
    }

}
