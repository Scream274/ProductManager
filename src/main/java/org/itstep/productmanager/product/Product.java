package org.itstep.productmanager.product;

public class Product {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String shortDescription;
    private Integer count;
    private boolean isForAdult;
    private boolean isOnSale;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isForAdult() {
        return isForAdult;
    }
    public void setForAdult(boolean forAdult) {
        isForAdult = forAdult;
    }

    public boolean isOnSale() {
        return isOnSale;
    }
    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", count=" + count +
                ", isForAdult=" + isForAdult +
                ", isOnSale=" + isOnSale +
                '}';
    }
}
