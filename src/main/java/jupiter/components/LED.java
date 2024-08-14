package jupiter.components;

/**
 * LED
 */
public class LED extends JCS_Component {
    
    public enum LED_Color {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        WHITE
    };

    private boolean isOn;
    private LED_Color color;

    public LED(LED_Color color, Orientation orientation) {
        super(orientation);
        this.color = color;
    }

    public void setColor(LED_Color color) {
        this.color = color;
    }

    public LED_Color getColor() {
        return color;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }
    
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return this.getColor().name() + " LED facing " + this.getOrientation().name();
    }

}
