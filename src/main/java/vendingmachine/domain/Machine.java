package vendingmachine.domain;// @ author ninaaano

import java.util.Map;
import java.util.SortedMap;

public class Machine {

    CoinStorage coinStorage = new CoinStorage();
    ItemStorage itemStorage = new ItemStorage();


    public SortedMap<Coin, Integer> getCoins() {
        return coinStorage.getCoins();
    }

    public void addCoins(SortedMap<Coin,Integer> coins) {
        coinStorage.addCoins(coins);
    }

    public void addItems(Map<String, Item> items) {
        itemStorage.addItems(items);
    }
}
