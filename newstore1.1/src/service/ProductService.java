package service;

import entity.Product;
import entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    static List<Product> productList;
    public static List<Product> docProductListTuFile() {
        File file = new File("products.txt");
        productList = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.split(",");

                Product product = new Product();
                product.setId(Integer.parseInt(info[0]));
                product.setName(info[1]);
                product.setPrice(Integer.parseInt(info[2]));
                productList.add(product);
            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return productList;
    }
    public void displayProductList() {
        List<Product> products = docProductListTuFile();
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
