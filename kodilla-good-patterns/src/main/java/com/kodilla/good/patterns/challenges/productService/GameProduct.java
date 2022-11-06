package com.kodilla.good.patterns.challenges.productService;

public class GameProduct implements ProductService{
    private String productName;
    private double productPrice;
    private double productWeight;
    public GameProduct(String productName, double productPrice, double productWeight){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
    }
    public ProductService productData() {
        return new GameProduct(productName, productPrice, productWeight);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
