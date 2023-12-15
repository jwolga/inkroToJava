package attestation.laptops;

import java.util.Map;
import java.util.HashMap;

public enum Brand {
    ASUS(1, "ASUS"),
    HP(2, "Dell"),
    DELL(3, "HM");

    private final int index;
    private final String stringValue;

    Brand(int index, String value) {
        this.index = index;
        this.stringValue = value;
    }

    public int getIndex() {
        return index;
    }

    public static Map<Integer, String> getOptions() {
        Map<Integer, String> result = new HashMap<>();
        for (Brand brand : Brand.values()) {
            result.put(brand.index, brand.stringValue);
        }
        return result;
    }

    public static Brand getByIndex(int index) {
        for (Brand brand : Brand.values()) {
            if (brand.index == index)
                return brand;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
