package jupiter.simulation;

import java.util.ArrayList;

import jupiter.components.JCS_Component;

public class JCS_Path {

    private ArrayList<JCS_Component> path = new ArrayList<>();

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

    public void printPath() {
        System.out.println(path);
    }

}
