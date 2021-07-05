package com.smirnovakv.products.dto;

import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.model.ProductCategory;

import java.util.List;

public class CategoryContainer {
    private ProductCategory productCategory;
    private Integer grams;
    private List<Product> products;

    public CategoryContainer(ProductCategory productCategory, Integer grams, List<Product> products) {
        this.productCategory = productCategory;
        this.grams = grams;
        this.products = products;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
