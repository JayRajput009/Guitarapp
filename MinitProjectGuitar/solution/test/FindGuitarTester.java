package com.aurionpro.MinitProjectGuitar.solution.test;

import java.util.List;
import java.util.Scanner;

import com.aurionpro.MinitProjectGuitar.solution.model.Builder;
import com.aurionpro.MinitProjectGuitar.solution.model.Guitar;
import com.aurionpro.MinitProjectGuitar.solution.model.GuitarSpec;
import com.aurionpro.MinitProjectGuitar.solution.model.Inventory;
import com.aurionpro.MinitProjectGuitar.solution.model.Model;
import com.aurionpro.MinitProjectGuitar.solution.model.Type;
import com.aurionpro.MinitProjectGuitar.solution.model.Wood;

public class FindGuitarTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        while (true) {
         
            System.out.println("1. Show full inventory");
            System.out.println("2. Search guitars by builder");
            System.out.println("3. Search guitars by type");
            System.out.println("4. Search guitars by full specification");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    for (Guitar guitar : inventory.getAllGuitars()) {
                        displayGuitar(guitar);
                    }
                    break;
                case 2:
                    Builder builder = selectBuilder(scanner);
                    GuitarSpec builderSpec = new GuitarSpec(builder, Model.ANY, null, null, null);
                    showMatching(inventory.search(builderSpec));
                    break;
                case 3:
                    Type type = selectType(scanner);
                    GuitarSpec typeSpec = new GuitarSpec(Builder.ANY, Model.ANY, type, null, null);
                    showMatching(inventory.search(typeSpec));
                    break;
                case 4:
                    Builder b = selectBuilder(scanner);
                    Model m = selectModel(scanner);
                    Type t = selectType(scanner);
                    Wood back = selectWood(scanner, "Back");
                    Wood top = selectWood(scanner, "Top");
                    GuitarSpec fullSpec = new GuitarSpec(b, m, t, back, top);
                    showMatching(inventory.search(fullSpec));
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V1001", 1499.95, Builder.FENDER, Model.STRATOCASTOR, Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        inventory.addGuitar("V1002", 1549.95, Builder.FENDER, Model.STRATOCASTOR, Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        inventory.addGuitar("V1003", 1219.95, Builder.MARTIN, Model.D28, Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.ADIDONDACK);
        inventory.addGuitar("V1004", 1399.95, Builder.GIBSON, Model.SG, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE);
        inventory.addGuitar("V1005", 1299.95, Builder.MARTIN, Model.CUSTOM, Type.ACOUSTIC, Wood.COCOBOLO, Wood.CEDAR);
        inventory.addGuitar("V1006", 1999.00, Builder.PRS, Model.CUSTOM, Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE);
    }

    private static Builder selectBuilder(Scanner scanner) {
        while (true) {
            System.out.println("Choose a builder:");
            for (Builder b : Builder.values()) {
                System.out.println((b.ordinal() + 1) + ". " + b);
            }
            int choice = readInt(scanner);
            if (choice > 0 && choice <= Builder.values().length) {
                return Builder.values()[choice - 1];
            }
            System.out.println("Invalid builder choice. Try again.");
        }
    }

    private static Model selectModel(Scanner scanner) {
        while (true) {
            System.out.println("Choose a model:");
            for (Model m : Model.values()) {
                System.out.println((m.ordinal() + 1) + ". " + m);
            }
            int choice = readInt(scanner);
            if (choice > 0 && choice <= Model.values().length) {
                return Model.values()[choice - 1];
            }
            System.out.println("Invalid model choice. Try again.");
        }
    }

    private static Type selectType(Scanner scanner) {
        while (true) {
            System.out.println("Choose a type:");
            for (Type t : Type.values()) {
                System.out.println((t.ordinal() + 1) + ". " + t);
            }
            int choice = readInt(scanner);
            if (choice > 0 && choice <= Type.values().length) {
                return Type.values()[choice - 1];
            }
            System.out.println("Invalid type choice. Try again.");
        }
    }

    private static Wood selectWood(Scanner scanner, String which) {
        while (true) {
            System.out.println("Choose " + which + " wood:");
            for (Wood w : Wood.values()) {
                System.out.println((w.ordinal() + 1) + ". " + w);
            }
            int choice = readInt(scanner);
            if (choice > 0 && choice <= Wood.values().length) {
                return Wood.values()[choice - 1];
            }
            System.out.println("Invalid wood choice. Try again.");
        }
    }

    private static void showMatching(List<Guitar> guitars) {
        if (guitars.isEmpty()) {
            System.out.println("No guitars found.");
        } else {
            for (Guitar guitar : guitars) {
                displayGuitar(guitar);
            }
        }
    }

    private static void displayGuitar(Guitar guitar) {
        GuitarSpec spec = guitar.getSpec();
        System.out.println("Serial: " + guitar.getSerialNumber() +
                ", Builder: " + spec.getBuilder() +
                ", Model: " + spec.getModel() +
                ", Type: " + spec.getType() +
                ", Back Wood: " + spec.getBackWood() +
                ", Top Wood: " + spec.getTopWood() +
                ", Price: $" + guitar.getPrice());
    }
}