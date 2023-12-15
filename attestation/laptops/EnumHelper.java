package attestation.laptops;

public class EnumHelper {
    public static String getBrand(Brand brand) {
        switch (brand) {
            case ASUS:
                return "ASUS";
            case DELL:
                return "Dell";
            case HP:
                return "HP";        
            default:
                return "Undefined";
        }
    }

    public static String getOperationSystem(OperationSystem os) {
        switch (os) {
            case WINDOWS_10_HOME:
                return "Windows 10 Home";
            case WINDOWS_10_PRO:
                return "Windows 10 Pro";
            case WINDOWS_11_HOME:
                return "Windows 11 Home";        
            case WINDOWS_11_PRO:
                return "Windows 11 Pro";        
            default:
                return "Undefined";
        }
    }    

    public static String getColor(Color color) {
        switch (color) {
            case BLACK:
                return "Black";
            case WHITE:
                return "White";
            case GRAY:
                return "Gray";        
            default:
                return "Undefined";
        }
    }    
}
