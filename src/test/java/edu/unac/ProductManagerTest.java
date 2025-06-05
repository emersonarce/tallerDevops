package edu.unac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void testAddAndGetProduct() {
        ProductManager manager = new ProductManager();
        Product p = new Product("1", "Laptop", "Electronics", 1200.0);
        manager.addProduct(p);

        Product result = manager.getProductById("1");
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void testDuplicateIdThrowsException() {
        ProductManager manager = new ProductManager();
        Product p1 = new Product("1", "Laptop", "Electronics", 1200.0);
        Product p2 = new Product("1", "Tablet", "Electronics", 800.0);

        manager.addProduct(p1);
        assertThrows(IllegalArgumentException.class, () -> manager.addProduct(p2));
    }

    @Test
    void testRemoveProduct() {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("1", "Laptop", "Electronics", 1200.0));
        manager.removeProduct("1");

        assertNull(manager.getProductById("1"));
    }

    @Test
    void testGetProductsByCategory() {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("1", "Laptop", "Electronics", 1200.0));
        manager.addProduct(new Product("2", "Shirt", "Clothing", 40.0));

        List<Product> electronics = manager.getProductsByCategory("Electronics");
        assertEquals(1, electronics.size());
        assertEquals("Laptop", electronics.get(0).getName());
    }

    @Test
    void testListAllProducts() {
        ProductManager manager = new ProductManager();
        Product p1 = new Product("1", "Laptop", "Electronics", 1200.0);
        Product p2 = new Product("2", "Shirt", "Clothing", 40.0);
        Product p3 = new Product("3", "Book", "Education", 25.0);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        List<Product> allProducts = manager.listAll();

        assertEquals(3, allProducts.size());
        assertTrue(allProducts.contains(p1));
        assertTrue(allProducts.contains(p2));
        assertTrue(allProducts.contains(p3));
    }
    @Test
    void checkItemsWithinPriceRange() {
    ProductManager inventory = new ProductManager();

        Product item1 = new Product("A1", "Tablet", "Technology", 1100.0);
        Product item2 = new Product("B2", "Sneakers", "Apparel", 35.0);
        Product item3 = new Product("C3", "Notebook", "Stationery", 25.0);
        Product item4 = new Product("D4", "Headphones", "Technology", 40.0);

        inventory.addProduct(item1);
        inventory.addProduct(item2);
        inventory.addProduct(item3);
        inventory.addProduct(item4);

        List<Product> filteredItems = inventory.getProductsByPriceRange(25.0, 40.0);

        assertEquals(3, filteredItems.size());
        assertTrue(filteredItems.contains(item2));
        assertTrue(filteredItems.contains(item3));
        assertTrue(filteredItems.contains(item4));
}
    
}