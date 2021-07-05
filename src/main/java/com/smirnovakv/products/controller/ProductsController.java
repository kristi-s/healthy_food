package com.smirnovakv.products.controller;

import com.smirnovakv.products.model.Product;
import com.smirnovakv.products.model.ProductCategory;
import com.smirnovakv.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productsService.getProductById(id);
    }

    @PostMapping("/{id}/{name}/{kkal}/{proteins}/{fats}/{carbohydrates}/{category}")
    public Product addProduct(@PathVariable Integer id, @PathVariable String name,
                              @PathVariable Integer kkal, @PathVariable Integer proteins,
                              @PathVariable Integer fats, @PathVariable Integer carbohydrates,
                              @PathVariable String category) {
        return productsService.addProduct(new Product(id, name, kkal, proteins,
                fats, carbohydrates, ProductCategory.valueOf(category.toUpperCase(Locale.ROOT))));
    }
}
