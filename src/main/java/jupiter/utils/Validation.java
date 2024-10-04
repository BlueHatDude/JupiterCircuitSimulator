package jupiter.utils;

/**
 * Validation
 */
public abstract class Validation {

    public static int constrainInt(int num, int min, int max) {
        if (num < min) {
            return min;
        } else if (num > max) {
            return max;
        } else {
            return num;
        }
    }

    /**
     * ! WARNING: unimplemented
     * 
     * @return
     */
    public static boolean valueInArray() {
        return false;
    }

}
