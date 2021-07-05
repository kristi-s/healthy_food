package com.smirnovakv.products.dao;
//data access object

import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsDao {

    private final List<Product> products;

    public ProductsDao() {
        this.products = new ArrayList<>();
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException("Bad id: " + id);
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> addBatchProducts(List<Product> productsListToAdd) {
        products.addAll(productsListToAdd);
        return productsListToAdd;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getCategory().equals(productCategory))
                .collect(Collectors.toList());
    }
}
