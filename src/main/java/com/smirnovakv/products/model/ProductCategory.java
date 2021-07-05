package com.smirnovakv.products.model;

public enum ProductCategory {
    VEGETABLE(400, 450, 300),
    FRUIT(200, 250, 150),
    MILK(500, 600, 300),
    FISH(150, 150, 80),
    MEAT(150, 150, 80),
    VEGETABLE_PROTEIN(150, 150, 100),
    GRAINS(200, 250, 150);

    private int gramsPerWoman;
    private int gramsPerMan;
    private int gramsPerChild;

    ProductCategory(int gramsPerWoman, int gramsPerMan, int gramsPerChild) {
        this.gramsPerWoman = gramsPerWoman;
        this.gramsPerMan = gramsPerMan;
        this.gramsPerChild = gramsPerChild;
    }

    public int getGramsPerWoman() {
        return gramsPerWoman;
    }

    public int getGramsPerMan() {
        return gramsPerMan;
    }

    public int getGramsPerChild() {
        return gramsPerChild;
    }
}
