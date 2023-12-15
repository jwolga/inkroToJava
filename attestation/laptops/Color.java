package attestation.laptops;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    BLACK(1, "Black"),
    WHITE(2, "White"),
    GRAY(3, "Gray");

    private final int index;
    private final String stringValue;

    Color(int index, String value) {
        this.index = index;
        this.stringValue = value;
    }

    public int getIndex() {
        return index;
    }

    public static Map<Integer, String> getOptions() {
        Map<Integer, String> result = new HashMap<>();
        for (Color color : Color.values()) {
            result.put(color.index, color.stringValue);
        }
        return result;
    }

    public static Color getByIndex(int index) {
        for (Color color : Color.values()) {
            if (color.index == index)
                return color;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
