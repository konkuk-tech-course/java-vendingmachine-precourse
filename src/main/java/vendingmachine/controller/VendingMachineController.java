package vendingmachine.controller;

import vendingmachine.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.Validator;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.Map;

public class VendingMachineController {

    private int inputMoney;

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
//        int money = inputView.readVendingMachineMoney();
        VendingMachine machine = new VendingMachine(1000);
        machine.convertMoneyToRandomCoin();
        System.out.println("money : " + machine.getMoney());

        Map<Coin, Integer> holdingMoney = machine.getHoldingMoney();
        System.out.println("holdingMoney : " + holdingMoney);

        outputView.printMachineCoin(holdingMoney);

        List<Product> products = inputView.readProductInfo();
        // 상품 최저가격 계산
        int minimumPrice = products.stream().mapToInt(Product::getPrice).min().getAsInt();

        //투입금액
        inputMoney = inputView.readInputMoney();
        // ---------------------

        // 아래 두 조건은 구매할 상품명 입력전 마다 확인해줘야 함
        // 상품이 모두 소진되었거나 minimum price보다 input이 적을때.
        while (true) {
            if (hasNoProduct(products) || isInputNotSmallerThanMinimunPrice(minimumPrice)) {
                outputView.printReturnedCoin(inputMoney);
                break;
            }
            String productName = inputView.readProductName(inputMoney);
            Validator.validateProductName(productName, products);

            Product matchedProduct = products.stream()
                    .filter(product -> product.getName().equals(productName))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 상품이 없습니다"));
            inputMoney -= matchedProduct.getPrice();
            matchedProduct.decreaseAmount();
        }
        // products에 productName과 같은 것 찾아서 가격만큼 투입 가격 감소시키기(inputMoney), product수량 감소시키기.



    }

    private boolean isInputNotSmallerThanMinimunPrice(int minimumPrice) {
        return inputMoney >= minimumPrice;
    }

    private boolean hasNoProduct(List<Product> products) {
        return products.stream().map(Product::getAmount)
                .allMatch(i -> i == 0);
    }

    public static void main(String[] args) {
        /*VendingMachine machine = new VendingMachine(1000);
        machine.convertMoneyToRandomCoin();
        int money = machine.getMoney();
        System.out.println("money = " + money);
        Map<Coin, Integer> holdingMoney = machine.getHoldingMoney();
        System.out.println("holdingMoney = " + holdingMoney);*/

        VendingMachineController controller = new VendingMachineController();
        controller.run();

    }
}
