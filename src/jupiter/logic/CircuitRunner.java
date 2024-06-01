package jupiter.logic;

import jupiter.components.JCS_Component;
import jupiter.components.JCS_Component.ComponentType;
import jupiter.ui.ComponentBoard;
import jupiter.utils.RowAndColumn;

abstract public class CircuitRunner {

    private ComponentBoard componentBoard;
    private RowAndColumn[] batteryCoordinates = new RowAndColumn[25];

    public CircuitRunner(ComponentBoard cb) {
        this.componentBoard = cb;
    }

    public void runCircuit() {
        
    }
    
    private void findCurrentPaths() {

    }

    private void findBatteries() {
        int cbRows = this.componentBoard.getRows();
        int cbColumns = this.componentBoard.getColumns();
        int bcIndex = 0;
        JCS_Component currentComponent;
        
        for (int r = 0; r < cbRows; r++) {
            for (int c = 0; c < cbColumns; c++) {
                currentComponent = componentBoard.getComponentAt(r, c);
                if ((currentComponent.getType() == ComponentType.BATTERY) &&
                        (currentComponent != null))
                {
                    batteryCoordinates[bcIndex].setCoordinates(r, c);
                }
            }
        }
    }

}
