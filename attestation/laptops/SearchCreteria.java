package attestation.laptops;

public class SearchCreteria {
    private SearchCreteriaType type;
    private Brand brand;
    private OperationSystem operationSystem;
    private Color color;
    private int minValue;
    private int maxValue;

    public SearchCreteria(SearchCreteriaType type, Brand brand, OperationSystem os, Color color, int min, int max) {
        setType(type);
        setBrand(brand);
        setOperatingSystem(os);
        setColor(color);
        setMinValue(min);
        setMaxValue(max);
    }

    public SearchCreteriaType getType() {
        return this.type;
    }

    public void setType(SearchCreteriaType value) {
        this.type = value;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand value) {
        this.brand = value;
    }

    public OperationSystem getOperationSystem() {
        return this.operationSystem;
    }

    public void setOperatingSystem(OperationSystem value) {
        this.operationSystem = value;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color value) {
        this.color = value;
    }

    public int getMinValue() {
        return this.minValue;
    }

    public void setMinValue(int value) {
        this.minValue = value;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(int value) {
        this.maxValue = value;
    }

    @Override
    public String toString() {
        String value = "(undefined)";
        switch (type) {
            case BRAND:
                value = isUndefined() ? "(undefined)" : "(currently selected '" + brand + "')";
                return "BRAND " + value;
            case COLOR:
                value = isUndefined() ? "(undefined)" : "(currently selected '" + color + "')";
                return "COLOR " + value; 
            case OPERATION_SYSTEM:
                value = isUndefined() ? "(undefined)" : "(currently selected '" + operationSystem + "')";
                return "OPERATING SYSTEM " + value;
            case RAM:
                value = isUndefined() ? "(undefined)" : "(between " + minValue + " and " + maxValue + ")";
                return "RAM " + value;
            case SSD:
                value = isUndefined() ? "(undefined)" : "(between " + minValue + " and " + maxValue + ")";
                return "SSD " + value;
            case PRICE:
                value = isUndefined() ? "(undefined)" : "(between " + minValue + " and " + maxValue + ")";
                return "PRICE " + value;
            case SEARCH:
                return "SEARCH";
            default:
                return "Invalid creteria type";
        }
    }

    public boolean isMatch(Laptop laptop) {
        if (laptop == null)
            return false;
        if (isUndefined())
            return true;
        switch (type) {
            case BRAND:
                return laptop.getBrand() == brand;
            case COLOR:
                return laptop.getColor() == color;
            case OPERATION_SYSTEM:
                return laptop.getOperationSystem() == operationSystem;
            case PRICE:
                return laptop.getPrice() >= minValue && laptop.getPrice() <= maxValue;
            case RAM:
                return laptop.getRam() >= minValue && laptop.getRam() <= maxValue;
            case SSD:
                return laptop.getSsd() >= minValue && laptop.getSsd() <= maxValue;
            case SEARCH: 
                return true;
            default:
                return false;
        }
    }

    public void clearValue() {
        setBrand(null);
        setColor(null);
        setOperatingSystem(null);
        setMinValue(0);
        setMaxValue(0);
    }

    private boolean isUndefined() {
        switch (type) {
            case BRAND:
                return brand == null;
            case COLOR:
                return color == null;
            case OPERATION_SYSTEM:
                return operationSystem == null;
            case PRICE:
            case RAM:
            case SSD:
                return minValue == 0 && maxValue == 0;
            case SEARCH: 
                return false;
            default:
                return false;
        }
    }
}
