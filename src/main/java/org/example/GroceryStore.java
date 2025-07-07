package org.example;

import java.util.Scanner;


public class GroceryStore {
    public static void main(String[] args) {
        //  define scanner object
        Scanner scannerObj = new Scanner(System.in);

        GroceryOperations groceryOperations = new GroceryOperations();

        //  start program
        while (true) {
            //  print out menu board for users to select operation
            menuBoard();

            //  user operation selection
            System.out.print("Choose an option (1-6): ");
            int optionInput = scannerObj.nextInt();

            switch (optionInput) {
                case 1:
                    groceryOperations.viewInventory();
                    break;
                case 2:
                    //  user inputs for item & quantity
                    System.out.print("\nEnter product name: ");
                    String itemInput = scannerObj.next();

                    System.out.print("Enter product quantity: ");
                    int quantityInput = scannerObj.nextInt();

                    //  add item & quantity to hashmap
                    groceryOperations.addProduct(itemInput, quantityInput);

                    System.out.printf("** Item [%s] has been added to inventory. **\n\n", itemInput);
                    break;
                case 3:
                    System.out.print("Enter product name to check: ");
                    String checkProductInput = scannerObj.next();

                    groceryOperations.checkProduct(checkProductInput);
                    break;
                case 4:
                    //  print out current inventory for users to select an item to update
                    groceryOperations.viewInventory();

                    while (true) {
                        //  product name input to update
                        System.out.print("Enter product name to check: ");
                        String productNameInput = scannerObj.next();

                        boolean isValidProduct = groceryOperations.validateProduct(productNameInput);

                        if (isValidProduct) {
                            //  product stock input to update
                            System.out.print("Enter new stock quantity: ");
                            int productQuantityInput = scannerObj.nextInt();

                            groceryOperations.updateProduct(productNameInput, productQuantityInput);
                            System.out.printf("** Item [%s] stock has been updated to -> [%s]. **\n\n", productNameInput, productQuantityInput);
                            //  break out while loop when product has been updated
                            break;
                        }
                        else {
                            System.out.printf("\nItem [%s] isn't available. Item might not included/wrong spelling.\n\n", productNameInput);
                        }
                    }
                    break;
                case 5:
                    //  print out current inventory for users to select an item to update
                    groceryOperations.viewInventory();

                    //  product name input to update
                    System.out.print("Enter product name to remove: ");
                    String productNameInput = scannerObj.next();

                    boolean isValidProduct = groceryOperations.validateProduct(productNameInput);

                    while (true) {
                        if (isValidProduct) {
                            groceryOperations.removeProduct(productNameInput);
                            System.out.printf("** Item [%s] has been removed from inventory. **\n\n", productNameInput);
                            //  break out while loop when product has been updated
                            break;
                        }
                        else {
                            System.out.printf("\nItem [%s] isn't available. Item might not included/wrong spelling.\n\n", productNameInput);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting System...");
                    System.out.println("----- Bye Bye! -----");
                    System.exit(0);
                    break;
            }
        }

    }
    //  method to store the grocery user guide UI menu board
    public static void menuBoard() {
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println(
                """
                1. View Inventory
                2. Add Product
                3. Check Product
                4. Update Stock
                5. Remove Product
                6. Exit
                """
        );
    }
}