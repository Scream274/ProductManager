package org.itstep.accountmanager.product;

public class ProductBuilder {
    private Product product = new Product();

    public ProductBuilder setId(Long id) {
        product.setId(id);
        return this;
    }

    public ProductBuilder setTitle(String title) {
        product.setTitle(title);
        return this;
    }

    public ProductBuilder setPrice(Double price) {
        product.setPrice(price);
        return this;
    }

    public ProductBuilder setDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductBuilder setShortDescription(String shortDescription) {
        product.setShortDescription(shortDescription);
        return this;
    }

    public ProductBuilder setCount(Integer count) {
        product.setCount(count);
        return this;
    }

    public ProductBuilder setForAdult(boolean forAdult){
        product.setForAdult(forAdult);
        return this;
    }

    public ProductBuilder setOnSale(boolean onSale){
        product.setOnSale(onSale);
        return this;
    }

    public Product getProduct(){
        return product;
    }

    public ProductBuilder reset(){
        product = new Product();
        return this;
    }
}
