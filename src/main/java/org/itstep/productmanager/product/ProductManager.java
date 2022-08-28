package org.itstep.productmanager.product;

import org.itstep.productmanager.readers.*;
import org.itstep.productmanager.writers.*;

import java.io.IOException;
import java.util.List;

public class ProductManager {

    public static void addProductsToJson(Product... products) throws IOException {
        for (Product product : products) {
            new JsonWriter().saveToFile(product);
        }
    }

    public static List<Product> getProductsFromJson() throws IOException {
        return new JsonReader().readFromFile();
    }

    public static Product getProductById(Long id) throws IOException, ProductNotFoundException {
        return new JsonReader().readProductById(id);
    }

    public static void changePrice(Long id, Double newPrice) throws IOException, ProductNotFoundException {
        List<Product> products = new JsonReader().readFromFile();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(newPrice);
                new JsonWriter().rewriteFile(products);
                return;
            }
        }
        throw new ProductNotFoundException("Product by id " + id + " was not found!");
    }

    public static void changeCount(Long id, Integer newCount) throws IOException, ProductNotFoundException {
        List<Product> products = new JsonReader().readFromFile();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setCount(newCount);
                new JsonWriter().rewriteFile(products);
                return;
            }
        }
        throw new ProductNotFoundException("Product by id " + id + " was not found!");
    }

    public static void showAllProducts() throws IOException {
        var products = getProductsFromJson();
        for (Product product : products) {
            System.out.println(product);
        }
    }


    public static void testInit() throws IOException {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        ProductBuilder pb = new ProductBuilder();

        product1 = pb.setTitle("Nokia 1100").
                setCount(10).
                setId(32L).
                setPrice(990D).
                setShortDescription("short description").
                setDescription("description").
                setForAdult(false).
                setOnSale(true).getProduct();

        product2 = pb.reset().
                setTitle("Siemens A55").
                setCount(12).
                setId(11L).
                setPrice(450D).
                setShortDescription("short description").
                setDescription("description").
                setForAdult(false).
                setOnSale(true).getProduct();

        product3 = pb.reset().
                setTitle("Motorola E398").
                setCount(5).
                setId(2L).
                setPrice(1820D).
                setShortDescription("short description").
                setDescription("description").
                setForAdult(false).
                setOnSale(true).getProduct();

        addProductsToJson(product1, product2, product3);
    }

}

