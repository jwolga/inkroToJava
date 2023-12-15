package attestation.laptops;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = getLaptops();

        Map<Integer, SearchCreteria> creterias = new HashMap<>();
        creterias.put(1, new SearchCreteria(SearchCreteriaType.BRAND, null, null, null, 0, 0));
        creterias.put(2, new SearchCreteria(SearchCreteriaType.RAM, null, null, null, 0, 0));
        creterias.put(3, new SearchCreteria(SearchCreteriaType.SSD, null, null, null, 0, 0));
        creterias.put(4, new SearchCreteria(SearchCreteriaType.OPERATION_SYSTEM, null, null, null, 0, 0));
        creterias.put(5, new SearchCreteria(SearchCreteriaType.PRICE, null, null, null, 0, 0));
        creterias.put(6, new SearchCreteria(SearchCreteriaType.COLOR, null, null, null, 0, 0));
        creterias.put(7, new SearchCreteria(SearchCreteriaType.SEARCH, null, null, null, 0, 0));

        processMenu(creterias);
    }

    static Set<Laptop> getLaptops() {
        Set<Laptop> result = new HashSet<>();
        result.add(new Laptop(Brand.ASUS, "ZenBook 14 Pro", 16, 512, 1800, OperationSystem.WINDOWS_10_PRO, Color.GRAY));
        result.add(new Laptop(Brand.ASUS, "ZenBook 15x", 32, 256, 1100, OperationSystem.WINDOWS_10_HOME, Color.WHITE));
        result.add(new Laptop(Brand.ASUS, "VivoBook 16 OLED", 16, 1024, 1760, OperationSystem.WINDOWS_11_HOME,
                Color.GRAY));
        result.add(
                new Laptop(Brand.ASUS, "VivoBook 16 PRO", 32, 2048, 2300, OperationSystem.WINDOWS_11_PRO, Color.BLACK));
        result.add(new Laptop(Brand.HP, "Pavilion 15", 16, 512, 1400, OperationSystem.WINDOWS_10_HOME, Color.GRAY));
        result.add(
                new Laptop(Brand.HP, "Pavilion 16 Pro", 32, 1024, 2100, OperationSystem.WINDOWS_11_PRO, Color.WHITE));
        result.add(new Laptop(Brand.DELL, "Lattitude 15", 8, 256, 1100, OperationSystem.WINDOWS_10_HOME, Color.GRAY));
        result.add(new Laptop(Brand.DELL, "Lattitude 16", 16, 512, 1540, OperationSystem.WINDOWS_11_HOME, Color.BLACK));
        result.add(new Laptop(Brand.DELL, "Lattitude 17", 32, 2048, 2600, OperationSystem.WINDOWS_11_PRO, Color.BLACK));
        return result;
    }

    static void processMenu(Map<Integer, SearchCreteria> menu) {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        boolean continueFlag = true;
        while (continueFlag) {
            do {
                printMenu(menu);
                if (!scanner.hasNextInt()) {
                    System.out.println("You should select an appropriate option. Try again.");
                    scanner.nextLine();
                    continue;
                }

                item = scanner.nextInt();
                if (!menu.containsKey(item)) {
                    System.out.println("You should select an appropriate option. Try again.");
                    //scanner.nextLine();
                    continue;
                }
                SearchCreteriaHelper.modifyCreteria(menu.get(item));

            } while (!menu.containsKey(item) || menu.get(item).getType() != SearchCreteriaType.SEARCH);
            printSet(search(getLaptops(), new HashSet<SearchCreteria>(menu.values())));
            System.out.println("Do you want to continue (y/n)?");            
            var res = scanner.next();
            continueFlag = res.equals("y");
        }

    }

    static void printMenu(Map<Integer, SearchCreteria> menu) {
        System.out.println("Select search creteria:");
        for (int i : menu.keySet())
            System.out.println(i + " - " + menu.get(i));
    }

    static void printSet(Set<Laptop> laptops) {
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }

    static Set<Laptop> search(Set<Laptop> laptops, Set<SearchCreteria> creterias) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean isMatch = true;
            for (SearchCreteria creteria : creterias) {
                isMatch &= creteria.isMatch(laptop);
            }
            if (isMatch)
                result.add(laptop);
        }
        return result;
    }
}
