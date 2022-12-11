package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import vendingmachine.model.Coin;
import vendingmachine.view.util.Unit;

public class OutputView {

    public void printCoinStatus(final Map<Coin, Integer> coinTable){
        for(Entry<Coin, Integer> eachCoinStatus : coinTable.entrySet()){
            StringJoiner status = new StringJoiner(Unit.SEPARATE_UNIT.getUnit());
            Coin coin = eachCoinStatus.getKey();
            int coinCount = eachCoinStatus.getValue();

            status.add(coin.getName());
            status.add(Integer.toString(coinCount));

            printMessage(status.toString());
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
