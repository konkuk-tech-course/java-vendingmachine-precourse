package vendingmachine.util.supporter;// @ author ninaaano

import vendingmachine.domain.Coin;

import java.util.SortedMap;

public class MapSupporter {
    public static void increaseCoinCount(SortedMap<Coin, Integer> coins, Coin keyCoin, final int initValue, final int value) {
        if(!coins.containsKey(keyCoin)){
            coins.put(keyCoin,initValue);
        }
        coins.replace(keyCoin,coins.get(keyCoin),coins.get(keyCoin)+value);
    }
}
