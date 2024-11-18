package com.service.service;

public class Product {
    private String name;
    private double price;
    private int quantityInStock;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.quantityInStock = stock;
    }

    public void changePrice(double newPrice){
        this.price = newPrice;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public int getStock(){
        return this.quantityInStock;
    }
}
