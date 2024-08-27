package app;

import jupiter.components.ComponentBoard;

import jupiter.simulation.CircuitRunner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ComponentBoard board = new ComponentBoard();
        CircuitRunner.runCircuit(board);
    }

}
