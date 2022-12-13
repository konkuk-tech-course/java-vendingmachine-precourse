package vendingmachine.domain;

import vendingmachine.utils.Util;

import java.util.List;

public class Product {

    private final String name;
    private final int price;
    private int amount;

    public Product(List<String> productList) {
        this.name = productList.get(0);
        this.price = Util.convertStringToProductPrice(productList.get(1));
        this.amount = Util.convertStringToInt(productList.get(2));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount() {
        this.amount -= 1;
    }
}
