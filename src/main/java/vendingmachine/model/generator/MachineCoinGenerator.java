package vendingmachine.model.generator;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.model.Coin;
import vendingmachine.model.generator.util.RandomAmountGenerator;

public class MachineCoinGenerator {
    private static final RandomAmountGenerator amountGenerator = new RandomAmountGenerator();

    public Map<Coin, Integer> settingMachineCoins(int inputMoney) {
        Map<Coin, Integer> coinTable = new HashMap<>();
        int divideAmount;
        int divideResult;
        do {
        } while (inputMoney > 0);
        return coinTable;
    }
    private int divideMoney(){
        return 0;
    }

}
