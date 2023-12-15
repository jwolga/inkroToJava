package attestation.laptops;

public class Laptop {
    private Brand brand;
    private String model;
    private int ram;
    private int ssd;
    private int price;
    private OperationSystem operationSystem;
    private Color color;

    public Laptop(Brand brand, String model, int ram, int ssd, int price, OperationSystem operationSystem, Color color) {
        setBrand(brand);
        setModel(model);
        setRam(ram);
        setSsd(ssd);
        setPrice(price);
        setOperationSystem(operationSystem);
        setColor(color);
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand value) {
        this.brand = value;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int value) {
        this.ram = value;
    }

    public int getSsd() {
        return this.ssd;
    }

    public void setSsd(int value) {
        this.ssd = value;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int value) {
        this.price = value;
    }

    public OperationSystem getOperationSystem() {
        return this.operationSystem;
    }

    public void setOperationSystem(OperationSystem value) {
        this.operationSystem = value;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color value) {
        this.color = value;
    }

    @Override
    public String toString() {
        return brand + ", " + model + ", " + ram + "GB, " + ssd + "GB, "
                + operationSystem + ", " + color + ", $" + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Laptop) {
            Laptop laptop = (Laptop) obj;
            return brand.equals(laptop.getBrand()) && model.equals(laptop.getModel()) && ram == laptop.getRam()
                    && ssd == laptop.getSsd() && price == laptop.getPrice()
                    && operationSystem.equals(laptop.getOperationSystem()) && color.equals(laptop.getColor());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() ^ model.hashCode() ^ ram ^ ssd ^ price ^ operationSystem.hashCode() ^ color.hashCode();
    }
}
