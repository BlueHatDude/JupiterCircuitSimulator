package jupiter.simulation;

import java.util.ArrayList;
import java.util.LinkedList;

import jupiter.components.ComponentBoard;
import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;
import jupiter.components.Orientation;
import jupiter.utils.Position;

/**
 * CircuitRunner
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
        ArrayList<Position> positions = new ArrayList<>();

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.componentExistsAt(i, j)) {
                    ComponentType type = board.getComponentAt(i, j).getType();
                    if (type == ComponentType.BATTERY)
                        positions.add(new Position(i, j));
                }
            }
        }

        return (Position[]) positions.toArray();
    }

    private static void handleBattery(ComponentBoard board, Position position) {
        /* find all current paths */

    }

    /***
     * Returns an array of JCS_Components that represents the path
     * that the current will follow. 
     * 
     * @param board
     * @param pos
     * @param next
     * @return
     */
    private static JCS_Component[] getComponentPath(ComponentBoard board, Position pos, Orientation next) {
        LinkedList<JCS_Component> components = new LinkedList<>();



        return (JCS_Component[]) components.toArray();
    }

    /***
     * Returns the next component in ComponentBoard given the current components 
     * position and orientation. If no next component is found, then this function
     * will return null
     * 
     * @param component
     * @param path
    */
    private static JCS_Component getNextComponent(ComponentBoard board, Position position) {
        JCS_Component component = board.getComponentAt(position);
        if (board.getComponentTo(component.getOrientation(), position) != null) {
            return component;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unused")
    private static void printPositions(ArrayList<Position> positions) {
        for (Position position : positions) {
            System.out.println(position);
        }
    }

}
