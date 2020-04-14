package com.codebreakers.tekstore;

public class Product {
    private String productName;
    private String productDescription;
    private String productPrice;
    private int productImage;

    public Product() {

    }

    public Product(String productName, String productDescription, String productPrice, int productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }


    //Getter
    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    //Setter


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
