package jupiter.simulation;

import java.util.ArrayList;

import jupiter.components.JCS_Component;

public class JCS_Path {

    enum ErrorCode {
        NO_ERROR,
        PATH_TERMINATES_EARLY,
        INFINITE_LOOP_DETECTED
    }

    private ArrayList<JCS_Component> path = new ArrayList<>();
    private ErrorCode errorCode;

    public void add(JCS_Component component) {
        path.add(component);
    }

    public ArrayList<JCS_Component> getPath() {
        return path;
    }

    public boolean componentInPath(JCS_Component component) {
        for (JCS_Component element : this.path) {
            if (element == component) {
                return true;
            }
        }
        return false;
    }

    public JCS_Component[] toArray() {
        return path.toArray(new JCS_Component[0]);
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public boolean errorHasOccured() {
        return !(this.getErrorCode() == ErrorCode.NO_ERROR);
    }

    public void printPath() {
        for (JCS_Component component : this.path) {
            System.out.println(component);
        }
    }

    public void printError() {
        switch (this.errorCode) {
            case NO_ERROR:
                System.out.println("No Error");
                break;
            case INFINITE_LOOP_DETECTED:
                System.out.println("Error: infinite loop detected in circuit");
                break;
            case PATH_TERMINATES_EARLY:
                System.out.println("Error: circuit is not closed");
                break;
            default:
                break;
            
        }
    }
}
