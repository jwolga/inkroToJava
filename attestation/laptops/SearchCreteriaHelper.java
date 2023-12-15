package attestation.laptops;

import java.util.Scanner;
import java.util.Map;

public class SearchCreteriaHelper {
    public static void modifyCreteria(SearchCreteria creteria) {
        if (creteria == null)
            return;

        if (creteria.getType() == SearchCreteriaType.SEARCH)
            return;

        Scanner scanner = new Scanner(System.in);
        int item = 0;
        while (item != 3) {
            System.out.println("Edit creteria " + creteria);
            System.out.println("Select option:");
            System.out.println("1 - Change value");
            System.out.println("2 - Clear value");
            System.out.println("3 - Exit");
            if (!scanner.hasNextInt()) {
                System.out.println("Select an appropriate option!");
                scanner.nextLine();
                continue;
            }
            item = scanner.nextInt();
            if (item < 1 || item > 3) {
                System.out.println("Select an appropriate option!");
                continue;
            }

            if (item == 1)
                editValue(creteria);

            if (item == 2)
                creteria.clearValue();
        }
    }

    static void editValue(SearchCreteria creteria) {
        switch (creteria.getType()) {
            case BRAND:
                editBrand(creteria);
                break;
            case COLOR:
                editColor(creteria);
                break;
            case OPERATION_SYSTEM:
                editOperationSystem(creteria);
                break;
            case PRICE:
                editPrice(creteria);
                break;
            case RAM:
                editRam(creteria);
                break;
            case SSD:
                editSsd(creteria);
                break;
            default:
                break;
        }
    }

    static void editBrand(SearchCreteria creteria) {
        var item = getValidOption(Brand.getOptions());
        creteria.setBrand(Brand.getByIndex(item));
    }

    static void editColor(SearchCreteria creteria) {
        var item = getValidOption(Color.getOptions());
        creteria.setColor(Color.getByIndex(item));

    }

    static void editOperationSystem(SearchCreteria creteria) {
        var item = getValidOption(OperationSystem.getOptions());
        creteria.setOperatingSystem(OperationSystem.getByIndex(item));
    }

    static void editPrice(SearchCreteria creteria) {3
        creteria.setMinValue(getIntegerValue("Input minimum value for the Price"));
        creteria.setMaxValue(getIntegerValue("Input minimum value for the Price"));
    }

    static void editRam(SearchCreteria creteria) {
        creteria.setMinValue(getIntegerValue("Input minimum value for the RAM"));
        creteria.setMaxValue(getIntegerValue("Input minimum value for the RAM"));
    }

    static void editSsd(SearchCreteria creteria) {
        creteria.setMinValue(getIntegerValue("Input minimum value for the SSD"));
        creteria.setMaxValue(getIntegerValue("Input minimum value for the SSD"));
    }

    static int getValidOption(Map<Integer, String> options) {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        while (true) {
            System.out.println("Select option:");
            for (var i : options.keySet()) {
                System.out.println(i + " - " + options.get(i));
            }
            if (!scanner.hasNextInt()) {
                System.out.println("Select an appropriate option!");
                scanner.nextLine();
                continue;
            }
            item = scanner.nextInt();
            if (!options.containsKey(item)) {
                System.out.println("Select an appropriate option!");
                continue;
            }

            break;
        }
        return item;
    }

    static int getIntegerValue(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            if (!scanner.hasNextInt()) {
                System.out.println("Value you entered is not a valid integer value!");
                scanner.nextLine();
                continue;
            }
            return scanner.nextInt();
        }
    }

}
