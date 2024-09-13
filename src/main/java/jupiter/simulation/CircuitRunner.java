package jupiter.simulation;

import java.util.ArrayList;
import jupiter.components.ComponentBoard;
import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;
import jupiter.simulation.JCS_Path.ErrorCode;
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

    public static void runCircuit(ComponentBoard board) {
        Position[] positions = findBatteries(board);

        for (Position position : positions) {
            handleBattery(board, position);
        }

    }

    private static Position[] findBatteries(ComponentBoard board) {
        ArrayList<Position> positions = new ArrayList<Position>();

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.componentExistsAt(i, j)) {
                    ComponentType type = board.getComponentAt(i, j).getType();
                    if (type == ComponentType.BATTERY)
                        positions.add(new Position(i, j));
                }
            }
        }

        return positions.toArray(new Position[0]);
    }

    private static void handleBattery(ComponentBoard board, Position position) {
        /* find all current paths */
        JCS_Path path = getComponentPath(board, position);

        if (path.errorHasOccured()) {
            path.printError();
        } else {
            path.printPath();
        }
    }

    /***
     * Returns an array of JCS_Components that represents the path
     * that the current will follow.
     * 
     * !WARNING: method currently assumes that the path given is valid.
     * 
     * @param board
     * @param pos
     * @param next
     * @return
     */
    private static JCS_Path getComponentPath(ComponentBoard board, Position pos) {
        JCS_Path path = new JCS_Path();
        JCS_Component start = board.getComponentAt(pos);
        JCS_Component current = start;
  
        while (current != null) {
            path.add(current);
            pos.move(current.getOrientation(), board.getRows(), board.getColumns());
            current = board.getComponentAt(pos);

            if (current == start) {
                path.setErrorCode(ErrorCode.NO_ERROR);
                break;
            } else if (path.componentInPath(current)) {
                /* the circuit loops back into itself */
                path.setErrorCode(ErrorCode.INFINITE_LOOP_DETECTED);
                break;
            }
        }

        /* component path ended early */
        if (current == null) {
            path.setErrorCode(ErrorCode.PATH_TERMINATES_EARLY);
        }

        return path;
    }

    @SuppressWarnings("unused")
    private static void printPositions(ArrayList<Position> positions) {
        for (Position position : positions) {
            System.out.println(position);
        }
    }

}
