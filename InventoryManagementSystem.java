import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Items want to store: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        String[] inventory = new String[capacity];
        inventory[0] = "note";
        inventory[1] = "book";
        int itemCount = 2;

        while (true) {
            System.out.print("What do you want to do with the list? (search, update, add, exit): ");
            String command = scanner.nextLine().toLowerCase();
            System.out.println("---------------");

            if (command.equals("exit")) {
                break;
            }

            switch (command) {
                case "add":
                    itemCount = addItem(inventory, itemCount, capacity, scanner);
                    break;
                case "search":
                    searchItem(inventory, itemCount, scanner);
                    break;
                case "update":
                    updateItem(inventory, itemCount, scanner);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

        scanner.close();
    }

    public static int addItem(String[] inventory, int itemCount, int capacity, Scanner scanner) {
        if (itemCount == capacity) {
            System.out.println("Sorry capacity reached");
            System.out.println("---------------");
            return itemCount;
        }

        System.out.print("What do you want to add? ");
        String itemToAdd = scanner.nextLine();
        inventory[itemCount] = itemToAdd;
        itemCount++;
        System.out.println("---------------");
        System.out.println("Item added: ");
        displayInventory(inventory, itemCount);
        return itemCount;
    }

    public static void updateItem(String[] inventory, int itemCount, Scanner scanner) {
        displayInventory(inventory, itemCount);
        System.out.print("Which element to be updated: ");
        String itemToUpdate = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].equals(itemToUpdate)) {
                inventory[i] = newItem;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("---------------");
            System.out.println("Item updated: ");
            displayInventory(inventory, itemCount);
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void searchItem(String[] inventory, int itemCount, Scanner scanner) {
        System.out.print("Enter the element to be searched: ");
        String searchItem = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].equals(searchItem)) {
                System.out.println(searchItem + " is found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(searchItem + " not found in inventory.");
        }
    }

    public static void displayInventory(String[] inventory, int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            System.out.print(inventory[i] + (i < itemCount - 1 ? ", " : "\n"));
        }
    }
}
