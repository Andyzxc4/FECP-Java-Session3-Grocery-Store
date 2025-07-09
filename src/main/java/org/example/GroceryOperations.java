package org.example;

import java.util.HashMap;

public class GroceryOperations {
    //  private hashmap 'inventory' to store product and quantity <product (String), Integer (Quantity)>
    private final HashMap<String, Integer> inventory = new HashMap<>();

    //  add a product in the inventory hashmap with method parameters of product name and its quantity
    public String addProduct (String product, int quant) {
        inventory.put(product, quant); //   add new product using .put()
        return String.format("** Product [%s] has been added to inventory **\n", product);
    }

    //  utilized containsKey() with 'product' as parameters to check if that product (key) is in the HashMap
    public String checkProduct(String product) {
        /*
            call out validateProduct() method that returns:
                true -> if the inputted product name exists in inventory (hashmap key)
                false -> if the inputted product name doesn't exist in inventory (hashmap key)
         */
        if (validateProduct(product)) {
            return String.format("%s is in stock: %s", product, inventory.get(product));
        } else {
            return String.format("Product [%s] isn't available. Product might not be included or wrong spelling.", product);
        }
    }

    //  update inventory using .replace() to edit product with new quantity stock
    public String updateProduct (String product, int quant) {
        /*
            call out validateProduct() method that returns:
                true -> if the inputted product name exists in inventory (hashmap key)
                false -> if the inputted product name doesn't exist in inventory (hashmap key)
         */
        if(validateProduct(product)) {
            inventory.replace(product, quant); //   update product using .replace()
            return String.format("** Product [%s] stock has been updated to -> [%s] **\n", product, quant);
        } else {
            return String.format("Product [%s] isn't available. Product might not included or wrong spelling.\n", product);
        }

    }

    //  delete product in inventory using .remove()
    public String removeProduct (String product) {
           /*
            call out validateProduct() method that returns:
                true -> if the inputted product name exists in inventory (hashmap key)
                false -> if the inputted product name doesn't exist in inventory (hashmap key)
         */
        if(validateProduct(product)) {
            inventory.remove(product); //   remove product using .remove(key)
            return String.format("\n** Product [%s] has been removed from inventory **", product);
        } else {
            return String.format("\nProduct [%s] isn't available. Product might not included or wrong spelling.", product);
        }

    }

    //  utilized containsKey() with 'product' as parameters to check if that product (key) is in the HashMap
    public boolean validateProduct (String product) {
        return inventory.containsKey(product); //   used .containsKey(key) to check if HashMap contains that key
    }

    //  getters
    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

}
