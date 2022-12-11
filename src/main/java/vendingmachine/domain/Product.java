package vendingmachine.domain;

import java.util.List;

public class Product {

    private String productName;
    private int productValue;
    private int productQuantity;


    public Product(String productName, int productValue, int productQuantity) {
        this.productName = productName;
        this.productValue = productValue;
        this.productQuantity = productQuantity;
    }


}