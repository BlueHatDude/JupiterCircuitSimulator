package jupiter.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jupiter.components.JCS_Component;

/**
 * GridSpaceHoverHandler
 */
public class GridSpaceHoverHandler extends MouseAdapter {

    private ComponentInfoPanel infoPanel;
    private ComponentBoard componentBoard;
    private int index;

    public GridSpaceHoverHandler(ComponentInfoPanel p, ComponentBoard cb, int index) {
        this.infoPanel = p;
        this.componentBoard = cb;
        this.index = index;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int[] coordinates = ComponentBoard.index1DtoIndex2D(index, componentBoard.getColumns());
        JCS_Component comp = componentBoard.getComponentAt(coordinates[0], coordinates[1]);
        infoPanel.updateInfo(comp);
    }
    
}
