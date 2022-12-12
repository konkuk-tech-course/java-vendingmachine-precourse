package vendingmachine.util.generator;// @ author ninaaano

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.util.supporter.MapSupporter;

import java.util.*;

public class CoinGenerator {


    public static SortedMap<Coin,Integer> generate(List<Integer> coinValues, Integer totalCoin) {
        SortedMap<Coin,Integer> coins = new TreeMap<>((c1,c2) -> c2.getAmount() - c1.getAmount());
        List<Coin> coinList = new ArrayList<>(Arrays.asList(Coin.values()));
        makeCoin(coinValues, totalCoin, coins, coinList);
        putNoCoins(coins,coinList);
        return coins;
    }

    private static void makeCoin(List<Integer> coinValues, Integer totalCoin, SortedMap<Coin, Integer> coins, List<Coin> coinList) {
        while(totalCoin > 0){
            int randomCoin = Randoms.pickNumberInList(coinValues);
            if(randomCoin > totalCoin){
                continue;
            }
            coinList.remove(Coin.getCoin(randomCoin));
            MapSupporter.increaseCoinCount(coins,Coin.getCoin(randomCoin),0,1);
            totalCoin -= randomCoin;
        }
    }

    private static void putNoCoins(SortedMap<Coin, Integer> coins, List<Coin> coinList) {
        for(Coin coin : coinList){
            coins.put(coin,0);
        }
    }
}
