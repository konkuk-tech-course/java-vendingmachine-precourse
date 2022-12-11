package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class ChangeGenerator {
    Map<Integer, Integer> coinMap = new HashMap<>();

    public Map<Integer, Integer> generate(int changes, List<Integer> coinList) {
        init();
        while(changes>0){
            int unit = Randoms.pickNumberInList(coinList);
            if(unit>changes){
                continue;
            }
            changes = addCoinMap(changes, unit);
        }
        return coinMap;
    }

    private int addCoinMap(int changes, int unit) {
        changes -= unit;
        coinMap.put(unit, coinMap.get(unit)+1);
        return changes;
    }

    private void init() {
        for(Coin coin : Coin.values()){
            coinMap.put(coin.getAmount(), 0);
        }
    }
}
