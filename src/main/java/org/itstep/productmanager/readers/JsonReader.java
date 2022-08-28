package org.itstep.productmanager.readers;

import org.itstep.productmanager.product.ProductConverter;
import org.itstep.productmanager.product.Product;
import org.itstep.productmanager.product.ProductNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonReader implements Reader {

    private static final String FILE_JSON = "products.json";

    @Override
    public List<Product> readFromFile() throws IOException {
        List<Product> products = new ArrayList<>();
        var productsStr = Files.readAllLines(Path.of(FILE_JSON));
        for (String str : productsStr) {
            products.add(ProductConverter.jsonToProduct(str));
        }
        return products;
    }

    @Override
    public Product readProductById(Long id) throws IOException, ProductNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_JSON));
        String line = reader.readLine();
        while (line != null) {
            Product product = ProductConverter.jsonToProduct(line);
            if (product.getId() == id) {
                return product;
            }
            line = reader.readLine();
        }
        throw new ProductNotFoundException("Product by id " + id + " was not found!");
    }
}
