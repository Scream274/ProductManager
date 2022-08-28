package org.itstep.accountmanager.product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductConverter {

    public static String productToJson(Product product) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(product);
    }

    public static Product jsonToProduct(String jsonString){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, Product.class);
    }

}
