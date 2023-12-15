package attestation.laptops;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = getLaptops();

        //printSet(laptops);

        printSet(filterPrice(laptops, 1400, 2000));
    }


    static Set<Laptop> getLaptops() {
        Set<Laptop> result = new HashSet<>();   
        result.add(new Laptop(Brand.ASUS, "ZenBook 14 Pro", 16, 512, 1800, OperationSystem.WINDOWS_10_PRO, Color.GRAY));
        result.add(new Laptop(Brand.ASUS, "ZenBook 15x", 32, 256, 1100, OperationSystem.WINDOWS_10_HOME, Color.WHITE));
        result.add(new Laptop(Brand.ASUS, "VivoBook 16 OLED", 16, 1024, 1760, OperationSystem.WINDOWS_11_HOME, Color.GRAY));
        result.add(new Laptop(Brand.ASUS, "VivoBook 16 PRO", 32, 2048, 2300, OperationSystem.WINDOWS_11_PRO, Color.BLACK));
        result.add(new Laptop(Brand.HP, "Pavilion 15", 16, 512, 1400, OperationSystem.WINDOWS_10_HOME, Color.GRAY));
        result.add(new Laptop(Brand.HP, "Pavilion 16 Pro", 32, 1024, 2100, OperationSystem.WINDOWS_11_PRO, Color.WHITE));
        result.add(new Laptop(Brand.DELL, "Lattitude 15", 8, 256, 1100, OperationSystem.WINDOWS_10_HOME, Color.GRAY));
        result.add(new Laptop(Brand.DELL, "Lattitude 16", 16, 512, 1540, OperationSystem.WINDOWS_11_HOME, Color.BLACK));
        result.add(new Laptop(Brand.DELL, "Lattitude 17", 32, 2048, 2600, OperationSystem.WINDOWS_11_PRO, Color.BLACK));
        return result;
    }

    static void printSet(Set<Laptop> laptops){
        for (Laptop laptop: laptops){
            System.out.println(laptop);
        }
    }
    
    static Set<Laptop> filterPrice(Set<Laptop> laptops, int min, int max) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getPrice() >= min && laptop.getPrice() <= max)
                result.add(laptop);
        }
        return result;
    }
}
