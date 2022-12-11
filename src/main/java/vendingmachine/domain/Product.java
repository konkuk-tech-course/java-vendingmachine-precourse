package vendingmachine.domain;

public class Product {
    private String productName;
    private int productValue;
    private int productQuantity;


    public Product(String productName, int productValue, int productQuantity) {
        this.productName = productName;
        this.productValue = productValue;
        this.productQuantity = productQuantity;
    }


    public int getProductValue() {
        return productValue;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
