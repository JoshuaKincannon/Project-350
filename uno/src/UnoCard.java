/**
 * Defines the main cards as objects
 * @author Jhoseph
 */
public class UnoCard {
    
    /**
     * Creates Enum variables to use as colors
     */
    enum Color {
        Red, Blue, Green, Yellow, Wild;

        private static final Color[] colors = Color.values();
        public static Color getColor(int i) {
            return Color.colors[i];
        }
    }
    
    /**
     * Creates Enum variables to use as values
     */
    enum Value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild, Wild_Four;

        private static final Value[] values = Value.values();
        public static Value getValue(int i) {
            return Value.values[i];
        }
    }

    private final Color color;
    private final Value value;

    /**
     * Constructor
     * @param color
     * @param value 
     */
    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    /**
     * Returns the color
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Returns the value
     * @return value
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Returns color and value as a string
     * @return string
     */
    public String toString() {
        return color + "_" + value;
    }
}
