package org.example;

import java.util.HashMap;

public class GroceryOperations {
    //  private hashmap 'inventory' to store product and quantity <product (String), Integer (Quantity)>
    private final HashMap<String, Integer> inventory = new HashMap<>();

    //  add a product in the inventory hashmap with method parameters of product name and its quantity
    public void addProduct (String product, int quant) {
        inventory.put(product, quant);
    }

    //  utilized containsKey() with 'product' as parameters to check if that product (key) is in the HashMap
    public String checkProduct(String product) {
        if (inventory.containsKey(product)) {
            return String.format("%s is in stock: %s", product, inventory.get(product));
        } else {
            return String.format("Product [%s] isn't available. Product might not be included or wrong spelling.", product);
        }
    }

    //  update inventory using .put() to edit product with new quantity stock
    public void updateProduct (String product, int quant) {
        inventory.replace(product, quant);
    }

    //  delete product in inventory using .remove()
    public void removeProduct (String product) {
        inventory.remove(product);
    }

    //  utilized containsKey() with 'product' as parameters to check if that product (key) is in the HashMap
    // this time we want to return boolean to validate product in st
    public boolean validateProduct (String product) {
        return inventory.containsKey(product);
    }

    //  getters
    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

}
