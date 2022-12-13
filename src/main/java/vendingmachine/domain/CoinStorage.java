package vendingmachine.domain;// @ author ninaaano

import vendingmachine.util.supporter.MapSupporter;

import java.util.SortedMap;
import java.util.TreeMap;

public class CoinStorage {
    public final SortedMap<Coin,Integer> coin = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
    private int inputCoinAmount;


    public SortedMap<Coin, Integer> getCoins() {
        return this.coin;
    }

    public void addCoins(SortedMap<Coin, Integer> coins) {
        for(Coin coin : coins.keySet()){
            MapSupporter.increaseCoinCount(this.coin,coin,0,coins.get(coin));
        }
    }

    public void addInputCoinAmount(final int amount) {
        this.inputCoinAmount += amount;
    }

    public int getInputCoinAmount() {
        return inputCoinAmount;
    }

    public void decreaseInputCoinAmount(int price) {
        inputCoinAmount -= price;
    }
}
