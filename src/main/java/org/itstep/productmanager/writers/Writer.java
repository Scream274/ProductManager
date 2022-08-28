package org.itstep.productmanager.writers;

import org.itstep.productmanager.product.Product;

import java.io.IOException;
import java.util.List;

public interface Writer {
    void saveToFile(Product product) throws IOException;
    void rewriteFile(List<Product> products) throws IOException;
}
