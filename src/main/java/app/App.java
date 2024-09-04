package app;

import jupiter.utils.Orientation;
import jupiter.components.Battery;
import jupiter.components.ComponentBoard;
import jupiter.components.Resistor;
import jupiter.components.Wire;
import jupiter.simulation.CircuitRunner;

/**
 * Hello world!
 
 */
public class App {

    public static void main(String[] args) {
        ComponentBoard board = new ComponentBoard();
        board.setComponentAt(0, 0, new Battery(9.0, Orientation.EAST));
        board.setComponentAt(0, 1, new Resistor(1_000, Orientation.SOUTH));
        board.setComponentAt(1, 1, new Wire(Orientation.WEST));
        board.setComponentAt(1, 0, new Wire(Orientation.NORTH));
        CircuitRunner.runCircuit(board);
    }

}
