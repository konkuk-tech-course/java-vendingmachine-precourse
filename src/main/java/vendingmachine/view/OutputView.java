package vendingmachine.view;

import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class OutputView {

    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputReadChanges() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void printCoinMap(Map<Integer, Integer> coinMap, List<Integer> coinList) {
        System.out.println("자판기가 보유한 동전");
        for(int coin : coinList){
            System.out.printf("%d원 - %d개\n", coin, coinMap.get(coin));
        }
    }

    public void printInputProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public void printInputReadInputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public void printHandOverChange(int amount, int coinCount) {
        System.out.printf("%d원-%d개\n", amount,coinCount);
    }

    public void printRemainInputMoney(int inputMoney) {
        System.out.println("투입 금액: " + inputMoney + "원");
    }

    public void printInputConsumeProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public void printLastRemainInputMoney(int inputMoney) {
        System.out.println("투입 금액: " + inputMoney + "원");
        System.out.println("잔돈");
    }
}
