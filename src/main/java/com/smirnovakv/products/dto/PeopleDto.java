package com.smirnovakv.products.dto;

public class PeopleDto {
    private int woman;
    private int man;
    private int child;

    public PeopleDto(int woman, int man, int child) {
        this.woman = woman;
        this.man = man;
        this.child = child;
    }

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }
}
