package vendingmachine.view;

import vendingmachine.Coin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

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
        loopMapWithMoney(holdingMoney, money);
        printIntoFormat(returnedCoin);
    }

    private void loopMapWithMoney(Map<Coin, Integer> holdingMoney, int money) {
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            Integer count = getCountWithNoZero(money, coinIntegerEntry);
            if (count == null) continue;
            if (coinIntegerEntry.getValue() < count) {
                money = calculateMoney(holdingMoney, money, coinIntegerEntry);
                continue;
            }
            money = calculateMoney(money, coinIntegerEntry, count);
        }
    }

    private Integer getCountWithNoZero(int money, Entry<Coin, Integer> coinIntegerEntry) {
        int count = getCount(money, coinIntegerEntry);
        if (isCountEqualsZero(count)){
            return null;
        }
        return count;
    }

    private int getCount(int money, Entry<Coin, Integer> coinIntegerEntry) {
        return money / coinIntegerEntry.getKey().getAmount();
    }

    private int calculateMoney(int money, Entry<Coin, Integer> coinIntegerEntry, int count) {
        returnedCoin.put(coinIntegerEntry.getKey(), count);
        money -= coinIntegerEntry.getKey().getAmount() * count;
        return money;
    }

    private int calculateMoney(Map<Coin, Integer> holdingMoney, int money, Entry<Coin, Integer> coinIntegerEntry) {
        returnedCoin.put(coinIntegerEntry.getKey(), coinIntegerEntry.getValue());
        money -= coinIntegerEntry.getValue();
        holdingMoney.remove(coinIntegerEntry.getKey());
        return money;
    }

    private static boolean isCountEqualsZero(int count) {
        return count == 0;
    }

    private int getTotalMachineMoney(Map<Coin, Integer> holdingMoney) {
        int totalMoney = 0;
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            totalMoney += coinIntegerEntry.getKey().getAmount() * coinIntegerEntry.getValue();
        }
        return totalMoney;
    }
}
