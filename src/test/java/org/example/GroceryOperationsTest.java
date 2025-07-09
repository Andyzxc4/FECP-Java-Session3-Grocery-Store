package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;


class GroceryOperationsTest {
    private final GroceryOperations groceryOperations = new GroceryOperations();

    @BeforeEach
    void setUp() {
        /*
            initialize in setup to add at least one product in inventory to make sure
            before each test case the HashMap isn't empty.
         */
        groceryOperations.addProduct("Cheese", 2);
    }

    // -- getInventory test case portion
    @Test
    void testGetInventory() {
        //  testing the results of get getInventory() method by checking the return type is HashMap or not
        assertEquals(HashMap.class, groceryOperations.getInventory().getClass());
    }

    // -- addProduct test case portion
    @Test
    void testAddProduct() {
        String expectedOutput = "** Product [Potato] has been added to inventory **\n";
        //  make sure that Potato is in the inventory as Key value of the HashMap
        assertEquals(expectedOutput, groceryOperations.addProduct("Potato", 7));
    }

    @Test
    void testAddProductThatAlreadyExist() {
        /*
            since our inventory is a HashMap data structure, replacing same Key (in this case we add Cheese as another product)
            all over again will just overwrite, since HashMap does not accept 'DUPLICATE' keys.

            add product Cheese that's already existed, and try to change the quantity to '7' instead of '2',
            since previously '2' was the quantity for Cheese
         */
        groceryOperations.addProduct("Cheese", 7);
        assertEquals(7, groceryOperations.getInventory().get("Cheese"));
    }

    // -- checkProduct test case portion
    @Test
    void testCheckProductWithValidProduct() {
        //  add product with quantity in HashMap to check
        groceryOperations.addProduct("Nachos", 3);

        String expectedOutput = "Nachos is in stock: 3";
        assertEquals(expectedOutput, groceryOperations.checkProduct("Nachos"));
    }

    @Test
    void testCheckProductWithInvalidProduct() {
        String expectedOutput = "Product [Test] isn't available. Product might not be included or wrong spelling.";
        assertEquals(expectedOutput, groceryOperations.checkProduct("Test"));
    }

    // -- updateProduct test case portion
    @Test
    void testUpdateProductWithValidProduct() {
        String expectedOutput = "** Product [Cheese] stock has been updated to -> [4] **\n";
        assertEquals(expectedOutput, groceryOperations.updateProduct("Cheese", 4));
    }

    @Test
    void testUpdateProductWithInvalidProduct() {
        String expectedOutput = "Product [Test] isn't available. Product might not included or wrong spelling.\n";
        assertEquals(expectedOutput, groceryOperations.updateProduct("Test", 4));
    }

    // -- removeProduct test case portion
    @Test
    void testRemoveProductWithValidProduct() {
        String expectedOutput = "\n** Product [Cheese] has been removed from inventory **";
        assertEquals(expectedOutput, groceryOperations.removeProduct("Cheese"));
    }

    @Test
    void testRemoveProductWithInvalidProduct() {
        String expectedOutput = "\nProduct [Test] isn't available. Product might not included or wrong spelling.";
        assertEquals(expectedOutput, groceryOperations.removeProduct("Test"));
    }

    /*
       -- validateProduct test case portion

        the validateProduct() method in GroceryOperations is utilized for validating product by returning:
            true -> if the inputted product name exists in inventory (hashmap key)
            false -> if the inputted product name doesn't exist in inventory (hashmap key)
     */
    @Test
    void testValidateValidProduct() {
        /*
            the validateProduct() method in GroceryOperations is utilized for validating product by returning:
                true -> if the inputted product name exists in inventory (hashmap key)
                false -> if the inputted product name doesn't exist in inventory (hashmap key)
         */
        assertTrue(groceryOperations.validateProduct("Cheese"));
    }

    @Test
    void testValidateInvalidProduct() {
        assertFalse(groceryOperations.validateProduct("Test"));
    }

}