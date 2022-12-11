package vendingmachine.model.generator;

import java.util.Map;
import vendingmachine.model.Coin;
import vendingmachine.model.generator.util.RandomAmountGenerator;

public class MachineCoinGenerator {
    private static final RandomAmountGenerator amountGenerator = new RandomAmountGenerator();
    private static final Map<Coin, Integer> COIN_TABLE = Map.of(
            Coin.COIN_500, 0,
            Coin.COIN_100, 0,
            Coin.COIN_50, 0,
            Coin.COIN_10, 0
    );
    private int inputMoney;

    public MachineCoinGenerator(int inputMoney){
        this.inputMoney = inputMoney;
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
