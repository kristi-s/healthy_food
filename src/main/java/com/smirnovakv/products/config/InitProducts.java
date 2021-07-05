package com.smirnovakv.products.config;

import com.smirnovakv.products.dao.ProductsFileParser;
import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.service.ProductsService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class InitProducts {

    private final static String filename = "products.txt";
    private final ProductsService productsService;
    private final ProductsFileParser productsFileParser;

    @Autowired
    InitProducts(ProductsService productsService, ProductsFileParser productsFileParser) {
        this.productsService = productsService;
        this.productsFileParser = productsFileParser;
    }

    @PostConstruct
    public void init() {
        List<Product> products = productsFileParser.parseFile(filename);
        for (Product product : products) {
            System.err.println(product);
        }
        productsService.addBatchProducts(products);
    }
}