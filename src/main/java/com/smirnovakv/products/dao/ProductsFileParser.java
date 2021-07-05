package com.smirnovakv.products.dao;

import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

@Component
public class ProductsFileParser {

    private static final int PRODUCTS_ARGS_COUNT = 7;
    private final List<Product> products;

    public ProductsFileParser() {
        this.products = new ArrayList<>();
    }

    private static Product createProductFromLine(String line) {
        if (line.isEmpty()) {
            return null;
        }

        String[] args = line.split(";");

        if (args.length != PRODUCTS_ARGS_COUNT) {
            throw new IllegalArgumentException("Bad elements count: " + args.length +
                    ". Product: " + args[0] + " " + args[1]);
        }

        return new Product(
                Integer.parseInt(args[0]),
                args[1],
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]),
                ProductCategory.valueOf(args[6].toUpperCase()));
    }

    public List<Product> parseFile(String filename) {

        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalStateException("bad file: " + filename);
        }

        try (Scanner scanner = new Scanner(new File(resource.getFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                products.add(createProductFromLine(line));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(filename, e);
        }
        return products;
    }
}
