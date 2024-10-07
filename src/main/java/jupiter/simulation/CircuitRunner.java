package jupiter.simulation;

import java.util.ArrayList;
import jupiter.components.ComponentBoard;
import jupiter.utils.Position;

/**
 * TODO: add Javadoc comment here
 */
public abstract class CircuitRunner {

    /**
     * caller POV
     * ```
     * CircuitRunner.runCircuit(board)
     * ```
     */

    public static void runCircuit(ComponentBoard board)  {
        ArrayList<Position> batteries = board.getBatteries();

        for (Position position : batteries) {

        }

    }

}
