package vendingmachine.model.generator;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import vendingmachine.model.Coin;
import vendingmachine.model.generator.util.RandomAmountGenerator;

public class MachineCoinGenerator {
    private static final RandomAmountGenerator amountGenerator = new RandomAmountGenerator();
//    private static final Map<Coin, Integer> COIN_TABLE = Map.of(
//            Coin.COIN_500, 0,
//            Coin.COIN_100, 0,
//            Coin.COIN_50, 0,
//            Coin.COIN_10, 0
//    );
    private static final SortedMap<Coin, Integer> COIN_TABLE = new TreeMap<>((coin1, coin2) -> -(coin1.getAmount() - coin2.getAmount()));
    private int inputMoney;

    public MachineCoinGenerator(int inputMoney){
        this.inputMoney = inputMoney;
        COIN_TABLE.put(Coin.COIN_500, 0);
        COIN_TABLE.put(Coin.COIN_100, 0);
        COIN_TABLE.put(Coin.COIN_50, 0);
        COIN_TABLE.put(Coin.COIN_10, 0);

    }

    public Map<Coin, Integer> settingMachineCoins() {
        do {
            int divideAmount = amountGenerator.generate();
            int amountCount = divideMoney(divideAmount);
            int oldValue = COIN_TABLE.get(Coin.by(divideAmount));
            COIN_TABLE.replace(Coin.by(divideAmount), oldValue+amountCount);
            updateInputMoney(divideAmount, amountCount);
        } while (inputMoney > 0);
        return COIN_TABLE;
    }
    private int divideMoney(int amount){
        return inputMoney/amount;
    }
    private void updateInputMoney(int amount, int count){
        this.inputMoney -= (amount*count);
    }
}
