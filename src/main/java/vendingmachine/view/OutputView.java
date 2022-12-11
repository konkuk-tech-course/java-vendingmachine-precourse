package vendingmachine.view;

import vendingmachine.Coin;

import java.util.Map;

public class OutputView {

    static final String format = "%d원 - %d개\n";

    public void printMachineCoin(Map<Coin, Integer> holdingMoney) {
        holdingMoney.forEach((coin, count) -> System.out.printf(format, coin.getAmount(), count));
    }
}
