package vendingmachine.domain;

import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Machine {

    private InputView inputView;
    private OutputView outputView;

    public Machine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void activate(int inputMoney, Map<String, Product> products, Map<Integer, Integer> coinMap) {
        int minMoney = findMinMoney(products);
        while (inputMoney >= minMoney && isProductsRemain(products)) {
            outputView.printRemainInputMoney(inputMoney);
            String s = controlReadConsumeProduct(products);
            products.get(s).setProductQuantity(products.get(s).getProductQuantity()-1);
            inputMoney-=findConsumeProductMoney(s, products);
        }
        outputView.printLastRemainInputMoney(inputMoney);
        handOverChange(coinMap, inputMoney);
    }

    private boolean isProductsRemain(Map<String, Product> products) {
        for(String s : products.keySet()){
            if(products.get(s).getProductQuantity()>0){
                return true;
            }
        }
        return false;
    }


    private void handOverChange(Map<Integer, Integer> coinMap, int inputMoney) {
        for(Coin coin:Coin.values()){
            if(inputMoney<coin.getAmount()){
                continue;
            }
            inputMoney = calculateChange(coinMap, inputMoney, coin);
        }

    }

    private int calculateChange(Map<Integer, Integer> coinMap, int inputMoney, Coin coin) { // 내가 가지고 있는 단위의 잔돈의 갯수만큼 반환
        int count=0;
        while(coinMap.get(coin.getAmount())>0 && inputMoney>0){
            inputMoney-=coin.getAmount();
            coinMap.put(coin.getAmount(), coinMap.get(coin.getAmount())-1);
            count++;
        }
        noPrintByNoCount(coin, count);
        return inputMoney;
    }

    private void noPrintByNoCount(Coin coin, int count) {
        if(count > 0) {
            outputView.printHandOverChange(coin.getAmount(), count);
        }
    }

    private int findConsumeProductMoney(String s, Map<String, Product> products) {
        int money=0;
        return products.get(s).getProductValue();

    }

    private String controlReadConsumeProduct(Map<String, Product> products) {
        String consumeProduct;
        try {
            outputView.printInputConsumeProduct();
            consumeProduct = validateProducts(inputView.readConsumeProduct(), products);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return controlReadConsumeProduct(products);
        }
        return consumeProduct;
    }

    private String validateProducts(String consumeProduct, Map<String, Product> products) {
        validateProductInProducts(consumeProduct, products);
        validateProductRemain(consumeProduct,products);
        return consumeProduct;
    }

    private void validateProductRemain(String consumeProduct, Map<String, Product> products) {
        if(products.get(consumeProduct).getProductQuantity()==0){
            throw new IllegalArgumentException("[ERROR] 해당 상품이 남아있지 않습니다.");
        }
    }

    private static void validateProductInProducts(String consumeProduct, Map<String, Product> products) {
        if (isConsumeProductInProducts(consumeProduct, products)) {
            throw new IllegalArgumentException("[ERROR] 해당 상품이 존재하지 않습니다.");
        }
    }

    private static boolean isConsumeProductInProducts(String consumeProduct,
        Map<String, Product> products) {
        return
            products.get(consumeProduct).getProductQuantity()==0;
    }

    private int findMinMoney(Map<String, Product> products) {
        int min=2121212121;
        for(String key:products.keySet()){
            int productValue = products.get(key).getProductValue();
            if(min>productValue){
                min=productValue;
            }
        }
        System.out.println(min);
        return min;
    }
}
