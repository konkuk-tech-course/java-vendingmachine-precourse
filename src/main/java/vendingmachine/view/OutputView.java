package vendingmachine.view;

import vendingmachine.Coin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import static vendingmachine.Coin.*;

public class OutputView {

    private static final String format = "%d원 - %d개\n";
    private final Map<Coin, Integer> returnedCoin = new LinkedHashMap<>();

    public void printMachineCoin(Map<Coin, Integer> holdingMoney) {
        System.out.println("자판기가 보유한 동전");
        printIntoFormat(holdingMoney);
    }

    private void printIntoFormat(Map<Coin, Integer> holdingMoney) {
        holdingMoney.forEach((coin, count) -> System.out.printf(format, coin.getAmount(), count));
    }

    public void printReturnedCoin(Map<Coin, Integer> holdingMoney, int money) {
        System.out.println("투입 금액: " + money + "원\n");
        System.out.println("잔돈");
        int totalMachineMoney = getTotalMachineMoney(holdingMoney);
        if (totalMachineMoney <= money){
            printIntoFormat(holdingMoney);
            return;
        }
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            int count = money / coinIntegerEntry.getKey().getAmount(); // 1770 / 500 == 3 // 실제 자판기 : 500원 4개
            if (count == 0) {
                continue;
            }
            if (coinIntegerEntry.getValue() < count) {
                // entry에서 지우기, money에서 값 만 큼 빼기
                returnedCoin.put(coinIntegerEntry.getKey(), coinIntegerEntry.getValue());
                money -= coinIntegerEntry.getValue();
                holdingMoney.remove(coinIntegerEntry.getKey());
                continue;
            }
            returnedCoin.put(coinIntegerEntry.getKey(), count);
            money -= coinIntegerEntry.getKey().getAmount() * count;
        }
        printIntoFormat(returnedCoin);
    }

    private int getTotalMachineMoney(Map<Coin, Integer> holdingMoney) {
        int totalMoney = 0;
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            totalMoney += coinIntegerEntry.getKey().getAmount() * coinIntegerEntry.getValue();
        }
        return totalMoney;
    }

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Map<Coin, Integer> map = new LinkedHashMap<>();
        map.put(COIN_500, 3);
        map.put(COIN_100, 5);
        map.put(COIN_50, 3);
        map.put(COIN_10, 1);
        outputView.printReturnedCoin(map, 1350);

    }
}
