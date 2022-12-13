package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.*;
import java.util.stream.Collectors;

public class VendingMachine {

    private int money;

    private final Map<Coin, Integer> holdingMoney = new LinkedHashMap<>();
    private final List<Integer> coins = Arrays.stream(Coin.values()).map(Coin::getAmount).collect(Collectors.toList());

    public VendingMachine(int money) {
        this.money = money;
        setHoldingMoney();
    }

    private void setHoldingMoney() {
        Arrays.stream(Coin.values()).forEach(coin -> holdingMoney.put(coin, 0));
    }

    public void convertMoneyToRandomCoin() {
        while (money != 0) {
            int generatedRandomCoin = generatedRandomCoin();
            if (cannotConvertMoneyToCoin(generatedRandomCoin)) continue;
            Coin coin = Coin.convertMatchingCoin(generatedRandomCoin);
            putCoinToMap(coin);
            money -= generatedRandomCoin;
        }
    }

    private boolean cannotConvertMoneyToCoin(int generatedRandomCoin) {
        return generatedRandomCoin > money;
    }

    private int generatedRandomCoin() {
        return Randoms.pickNumberInList(coins);
    }

    private void putCoinToMap(Coin coin) {
        holdingMoney.put(coin, holdingMoney.get(coin) + 1);
    }

    public Map<Coin, Integer> getHoldingMoney() {
        return holdingMoney;
    }

    public static void main(String[] args) {
    }
}
