package vendingmachine.controller;

import vendingmachine.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.Validator;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class VendingMachineController {

    private final InputView inputView;

    private final OutputView outputView;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private int inputMoney;

    public void run() {
        try {
            process();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void process() {
        int money = inputView.readVendingMachineMoney();
        VendingMachine machine = new VendingMachine(money);
        machine.convertMoneyToRandomCoin();
        Map<Coin, Integer> holdingMoney = machine.getHoldingMoney();
        outputView.printMachineCoin(holdingMoney);
        List<Product> products = inputView.readProductInfo();
        int minimumPrice = getMinimumPrice(products);
        inputMoney = inputView.readInputMoney();
        getProductName(products, minimumPrice);
        outputView.printReturnedCoin(holdingMoney, inputMoney);
    }

    private void getProductName(List<Product> products, int minimumPrice) {
        while (isRightCondition(products, minimumPrice)) {
            String productName = getAndValidateProductName(products);
            Product matchedProduct = getMatchedProduct(products, productName);
            inputMoney -= matchedProduct.getPrice();
            matchedProduct.decreaseAmount();
        }
    }

    private static Product getMatchedProduct(List<Product> products, String productName) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 상품이 없습니다"));
    }

    private String getAndValidateProductName(List<Product> products) {
        String productName = inputView.readProductName(inputMoney);
        Validator.validateProductName(productName, products);
        return productName;
    }

    private boolean isRightCondition(List<Product> products, int minimumPrice) {
        return !hasNoProduct(products) && isInputNotSmallerThanMinimunPrice(minimumPrice);
    }

    private int getMinimumPrice(List<Product> products) {
        OptionalInt minimumPrice = products.stream().mapToInt(Product::getPrice).min();
        if (minimumPrice.isPresent()) {
            return minimumPrice.getAsInt();
        }
        throw new IllegalArgumentException("[ERROR] 최솟값을 구할 수 없습니다");
    }

    private boolean isInputNotSmallerThanMinimunPrice(int minimumPrice) {
        return inputMoney >= minimumPrice;
    }

    private boolean hasNoProduct(List<Product> products) {
        return products.stream()
                .map(Product::getAmount)
                .allMatch(i -> i == 0);
    }
}