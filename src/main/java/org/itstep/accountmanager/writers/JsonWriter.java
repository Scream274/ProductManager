package org.itstep.accountmanager.writers;

import org.itstep.accountmanager.product.ProductConverter;
import org.itstep.accountmanager.product.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonWriter implements Writer {

    private static final String FILE_JSON = "products.json";

    @Override
    public void saveToFile(Product product) throws IOException {
        String str = ProductConverter.productToJson(product);

        try (FileWriter writer = new FileWriter(FILE_JSON, true)) {
            writer.write(str + System.lineSeparator());
        }
    }

    @Override
    public void rewriteFile(List<Product> products) throws IOException {
        Files.writeString(Path.of(FILE_JSON),"");
        for (Product product : products) {
            saveToFile(product);
        }
    }
}
