package org.itstep.accountmanager.readers;

import org.itstep.accountmanager.product.Product;
import org.itstep.accountmanager.product.ProductNotFoundException;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Product> readFromFile() throws IOException;
    Product readProductById(Long id) throws IOException, ProductNotFoundException;
}
