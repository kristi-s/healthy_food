package com.smirnovakv.products.model;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private int kkal;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private ProductCategory category;

    public Product(int id, String name, int kkal, int proteins,
                   int fats, int carbohydrates, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.kkal = kkal;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKkal() {
        return kkal;
    }

    public void setKkal(int kkal) {
        this.kkal = kkal;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && kkal == product.kkal && proteins == product.proteins && fats == product.fats && carbohydrates == product.carbohydrates && Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kkal, proteins, fats, carbohydrates, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kkal=" + kkal +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", category=" + category +
                '}';
    }
}
