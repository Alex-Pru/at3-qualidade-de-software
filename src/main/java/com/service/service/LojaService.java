package com.service.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LojaService {

    private List<Product> stockList;

    public LojaService(){
        this.stockList = Collections.emptyList();
    }

    public LojaService(List<Product> products){
        this.stockList = products;
    }

    public void insertProduct(Product newProduct){
        this.stockList.add(newProduct);
    }

    public Product getProduct(){
        return this.stockList.getLast();
    }

    public double getTotalAmount(List<Product> products, int discount){

        if(discount < 0 || discount > 70){
            throw new IllegalArgumentException("The discount may not be less than 0% or more than 70%");
        }

        if(products.isEmpty()){
            return 0.0;
        }

        double sum = products.stream().mapToDouble(Product::getPrice).sum();

        return sum - sum/100 * discount;
    }

    public List<Product> getProductsInStock(List<Product> productsList){

        if (productsList == null) {
            throw new IllegalArgumentException("The product list cannot be null");
        }

        if(productsList.isEmpty()){
            List<Product> products = Collections.emptyList();
            return products;
        }

        List<Product> productsInStock = productsList.stream().filter(product -> product.getStock() > 0).collect(Collectors.toList());

        return productsInStock;
    }

    public boolean couponValidation(String coupon){
        if(coupon.length() != 7){
            throw new IllegalArgumentException("Coupon does not have enough characters");
        }

        if(!coupon.startsWith("CUPOM-")){
            throw new IllegalArgumentException("Coupon does not match the expected pattern");
        }

        return true;
    }

    public double[] orderPrices(List<Product> productList){
        if(productList.isEmpty()){
            double[] values = {};
            return values;
        }

        if(productList == null){
            throw new IllegalArgumentException("Argument must be a list of products");
        }

        double[] orderedPrices = productList
                .stream()
                .sorted((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()))
                .mapToDouble(Product::getPrice)
                .toArray();

        return orderedPrices;
    }

    public String[] checkStock(List<Product> productsList, int limitMin){
        if(productsList == null || productsList.isEmpty()){
            throw new IllegalArgumentException("A products list is expected");
        }

        if(limitMin < 1){
            throw new IllegalArgumentException("The minimum limit must bigger than 1");
        }

        String[] lowStockProducts = productsList.stream().filter(product ->  product.getStock() < limitMin).map(Product::getName).toArray(String[]::new);
        return lowStockProducts;
    }
}
