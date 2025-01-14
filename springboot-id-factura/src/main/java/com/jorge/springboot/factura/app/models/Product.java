package com.jorge.springboot.factura.app.models;

public class Product {

    private String name;
    private Integer Price;

    public Product(String name, Integer price) {
        this.name = name;
        Price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }
}
