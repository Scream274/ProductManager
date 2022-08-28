package org.itstep.accountmanager;

import org.itstep.accountmanager.product.*;

import java.io.IOException;
import java.util.Scanner;

public class ProductManagerMain {
    public static void main(String[] args) throws IOException {

        ProductManager.testInit();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new product");
            System.out.println("2. Change count of product");
            System.out.println("3. Change price of product");
            System.out.println("4. View all products");

            System.out.print("->>");

            String choose = scanner.nextLine();

            if (choose.equals("1")) {
                Product product;
                ProductBuilder pb = new ProductBuilder();

                try {
                    System.out.println("Input product ID:");
                    String idStr = scanner.nextLine();
                    Long id = Long.valueOf(idStr);

                    System.out.println("Input title:");
                    String title = scanner.nextLine();

                    System.out.println("Input count:");
                    String countStr = scanner.nextLine();
                    Integer count = Integer.valueOf(countStr);

                    System.out.println("Input price:");
                    String priceStr = scanner.nextLine();
                    Double price = Double.valueOf(priceStr);

                    product = pb.setId(id).
                            setTitle(title).
                            setCount(count).
                            setPrice(price).getProduct();

                    ProductManager.addProductsToJson(product);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input format!");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (choose.equals("2")) {
                try {
                    System.out.println("Input product id:");
                    String idStr = scanner.nextLine();
                    Long id = Long.valueOf(idStr);

                    System.out.println("Input new count:");
                    String countStr = scanner.nextLine();
                    Integer count = Integer.valueOf(countStr);

                    ProductManager.changeCount(id, count);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong input format!");
                }

            } else if (choose.equals("3")) {
                try {
                    System.out.println("Input product id:");
                    String idStr = scanner.nextLine();
                    Long id = Long.valueOf(idStr);

                    System.out.println("Input new price:");
                    String priceStr = scanner.nextLine();
                    Double price = Double.valueOf(priceStr);

                    ProductManager.changePrice(id, price);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong input format!");
                }
            } else if (choose.equals("4")) {
                ProductManager.showAllProducts();
            } else {
                break;
            }
        }
    }
}
