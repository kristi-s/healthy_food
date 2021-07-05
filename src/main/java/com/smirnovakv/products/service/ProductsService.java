package com.smirnovakv.products.service;

import com.smirnovakv.products.dao.ProductsDao;
import com.smirnovakv.products.dao.ProductsFileParser;
import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsDao productsDao;

    @Autowired
    public ProductsService(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    public Product getProductById(int id) {
        return productsDao.getProductById(id);
    }

    public Product addProduct(Product product) {
        productsDao.addProduct(product);
        return product;
    }

    public List<Product> addBatchProducts(List<Product> products) {
        return productsDao.addBatchProducts(products);
    }

    public List<Product> getAllProducts() {
        return productsDao.getAllProducts();
    }
}
