package attestation.laptops;

import java.util.HashMap;
import java.util.Map;

public enum OperationSystem {
    WINDOWS_10_HOME(1, "Windows 10 Home"),
    WINDOWS_10_PRO(2, "Windows 10 Pro"),
    WINDOWS_11_HOME(3, "Windows 11 Home"),
    WINDOWS_11_PRO(4, "Windows 11 Pro");

    private final int index;
    private final String stringValue;

    OperationSystem(int index, String value) {
        this.index = index;
        this.stringValue = value;
    }

    public int getIndex() {
        return index;
    }

    public static Map<Integer, String> getOptions() {
        Map<Integer, String> result = new HashMap<>();
        for (OperationSystem os : OperationSystem.values()) {
            result.put(os.index, os.stringValue);
        }
        return result;
    }

    public static OperationSystem getByIndex(int index) {
        for (OperationSystem os : OperationSystem.values()) {
            if (os.index == index)
                return os;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
