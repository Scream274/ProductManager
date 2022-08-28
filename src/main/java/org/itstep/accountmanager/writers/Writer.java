package org.itstep.accountmanager.writers;

import org.itstep.accountmanager.product.Product;

import java.io.IOException;
import java.util.List;

public interface Writer {
    void saveToFile(Product product) throws IOException;
    void rewriteFile(List<Product> products) throws IOException;
}
