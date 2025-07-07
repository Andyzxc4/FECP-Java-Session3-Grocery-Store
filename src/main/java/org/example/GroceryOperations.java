package org.example;

import java.util.HashMap;

public class GroceryOperations {
    //  private hashmap 'inventory' to store item and quantity <Item (String), Integer (Quantity)>
    private HashMap<String, Integer> inventory = new HashMap<>();

    //  add an item in the inventory hashmap with method parameters of item name and its quantity
    public void addProduct (String item, int quant) {
        inventory.put(item, quant);
    }

    //  utilized containsKey() with 'item' as parameters to check if that item (key) is in the HashMap
    // this time we want to return boolean to validate product in st
    public boolean validateProduct (String item) {
        return inventory.containsKey(item);
    }

    //  utilized containsKey() with 'item' as parameters to check if that item (key) is in the HashMap
    public void checkProduct (String item) {
        if (inventory.containsKey(item)) {
            System.out.printf("\n%s is in stock: %s\n\n", item, (inventory.get(item)));
        }
        else {
            System.out.printf("\nItem [%s] isn't available. Item might not included/wrong spelling.\n\n", item);
        }
    }

    //  update inventory using .put() to edit item with new quantity stock
    public void updateProduct (String item, int quant) {
        inventory.replace(item, quant);
    }

    //  delete item in inventory using .remove()
    public void removeProduct (String item) {
        inventory.remove(item);
    }

    //  check first if the inventory hashmap is empty, if not, will print out each item using lambda
    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("\n* empty inventory *\n");
        }
        else {
            System.out.println("\nCurrent Inventory:");
            inventory.forEach((item, quantity) -> {
                System.out.println(item + " - " + quantity);
            });
            System.out.println();
        }

    }

}
