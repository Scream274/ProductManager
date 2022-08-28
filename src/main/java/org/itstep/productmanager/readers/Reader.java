package org.itstep.productmanager.readers;

import org.itstep.productmanager.product.Product;
import org.itstep.productmanager.product.ProductNotFoundException;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Product> readFromFile() throws IOException;
    Product readProductById(Long id) throws IOException, ProductNotFoundException;
}
