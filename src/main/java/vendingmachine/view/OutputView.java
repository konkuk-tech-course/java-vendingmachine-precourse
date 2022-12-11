package vendingmachine.view;

import vendingmachine.Coin;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    static final String format = "%d원 - %d개\n";

    public void printMachineCoin(Map<Coin, Integer> holdingMoney) {
        holdingMoney.forEach((coin, count) -> System.out.printf(format, coin.getAmount(), count));
    }

    public void printReturnedCoin(Map<Coin, Integer> holdingMoney, int money) {
        System.out.println("투입 금액: " + money + "원\n");
        // 자판기가 가지고 있는 돈이 money보다 적을 경우 다 주기
        int totalMachineMoney = getTotalMachineMoney(holdingMoney);
        if (totalMachineMoney <= money){
            System.out.println("잔돈");
            printMachineCoin(holdingMoney);
            return;
        }
        // 투입금액이 크지 않으면 최소개수로 반환
        // 먼저 500원부터 반환해주고, 100원 반환해주고 , 50원 반환해주고, 10원 반환해주고
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            int count = money % coinIntegerEntry.getKey().getAmount();
            if (coinIntegerEntry.getValue() < count) {
                // entry에서 지우기

            }
            money -= coinIntegerEntry.getKey().getAmount() * count;
            holdingMoney.put(coinIntegerEntry.getKey(), holdingMoney.get(coinIntegerEntry.getKey()) - count);
        }

        int five_hundred = money % Coin.COIN_500.getAmount();
        holdingMoney.get(Coin.COIN_500);


        // 잔돈 출력
        System.out.println();
    }

    private int getTotalMachineMoney(Map<Coin, Integer> holdingMoney) {
        int totalMoney = 0;
        for (Entry<Coin, Integer> coinIntegerEntry : holdingMoney.entrySet()) {
            totalMoney += coinIntegerEntry.getKey().getAmount() * coinIntegerEntry.getValue();
        }
        return totalMoney;
    }
}
