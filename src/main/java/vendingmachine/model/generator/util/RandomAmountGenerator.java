package vendingmachine.model.generator.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import vendingmachine.model.Coin;

public class RandomAmountGenerator implements NumberGenerator{

    private static final List<Integer> COIN_LIST = Arrays.asList(
            Coin.COIN_500.getAmount(),
            Coin.COIN_100.getAmount(),
            Coin.COIN_50.getAmount(),
            Coin.COIN_10.getAmount());

    @Override
    public int generate() {
        return Randoms.pickNumberInList(COIN_LIST);
    }
}
