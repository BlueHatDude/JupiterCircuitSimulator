package jupiter.simulation;

import java.util.ArrayList;
import java.util.LinkedList;

import jupiter.components.ComponentBoard;
import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;
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
        JCS_Component[] path = getComponentPath(board, position);
        printPath(path);
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
    private static JCS_Component[] getComponentPath(ComponentBoard board, Position pos) {
        LinkedList<JCS_Component> path = new LinkedList<JCS_Component>();
        JCS_Component startComponent = board.getComponentAt(pos);
        JCS_Component currentComponent = getNextComponent(board, pos);

        while (currentComponent != null) {
            path.add(currentComponent);
            pos.move(currentComponent.getOrientation(), board.getRows(), board.getColumns());
            currentComponent = getNextComponent(board, pos);

            if (currentComponent == startComponent) {
                break;
            }
        }

        return path.toArray(new JCS_Component[0]);
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

    @SuppressWarnings("unused")
    private static void printPath(JCS_Component[] path) {
        for (JCS_Component component : path) {
            System.out.println(component);
        }
    }

}
