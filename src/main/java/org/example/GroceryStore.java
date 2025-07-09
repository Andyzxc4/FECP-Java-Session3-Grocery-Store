package org.example;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GroceryStore {
    public static void main(String[] args) {
        //  define scanner object
        Scanner scannerObj = new Scanner(System.in);

        //  declare GroceryOperations object
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
                    viewInventory(groceryOperations.getInventory());
                    break;
                case 2:
                    //  user input for product
                    System.out.print("\nEnter product name: ");
                    String productInput = scannerObj.next();

                    //  use while loop to handle closing of the program when user inputted non integer for quantity
                    while (true) {
                        //  utilize try catch to validate 'int' input of quantity
                        try {
                            //  user input for quantity
                            System.out.print("Enter product quantity: ");
                            int quantityInput = scannerObj.nextInt();

                            //  add product & quantity to hashmap and prints out message
                            System.out.println(groceryOperations.addProduct(productInput, quantityInput));

                            break; // break out of the while loop if the inputted value for quantity is an Integer
                        } catch (InputMismatchException e) {
                            System.out.println("Quantity should be an Integer. Try Again...\n");
                            scannerObj.nextLine(); // consume the invalid input to avoid infinite loop
                        }
                    }
                    break;
                case 3:
                    //  user input for product name
                    System.out.print("Enter product name to check: ");
                    String checkProductInput = scannerObj.next();

                    //  check product and prints out message
                    System.out.println(groceryOperations.checkProduct(checkProductInput));
                    break;
                case 4:
                    //  print out current inventory for users to select a product to update
                    viewInventory(groceryOperations.getInventory());

                    //  product name input to update
                    System.out.print("Enter product name to update: ");
                    String productNameInput = scannerObj.next();

                    while (true) {
                        //  utilize try catch to validate 'int' input of new stock quantity
                        try {
                            //  product stock input to update
                            System.out.print("Enter new stock quantity: ");
                            int productQuantityInput = scannerObj.nextInt();

                            //  update product and prints out message
                            System.out.println(groceryOperations.updateProduct(productNameInput, productQuantityInput));
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Quantity should be an Integer. Try Again...\n");
                            scannerObj.nextLine(); // consume the invalid input to avoid infinite loop
                        }
                    }
                    break;
                case 5:
                    //  print out current inventory for users to select a product to update
                    viewInventory(groceryOperations.getInventory());

                    //  product name input to update
                    System.out.print("Enter product name to remove: ");
                    String productInputToRemove = scannerObj.next();

                    //  remove product and prints out message
                    System.out.println(groceryOperations.removeProduct(productInputToRemove));
                    break;
                case 6:
                    System.out.println("Exiting System...");
                    System.out.println("----- Bye Bye! -----");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nNo such input. Try Again.\n");
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

    //  check first if the inventory hashmap is empty, if not, will print out each product using lambda
    public static void viewInventory(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("\n* empty inventory *\n");
        }
        else {
            System.out.println("\nCurrent Inventory:");
            inventory.forEach((product, quantity) -> System.out.println(product + " - " + quantity));
        }
    }

}