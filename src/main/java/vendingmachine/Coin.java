package vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin convertMatchingCoin(int money) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == money)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 코인이 없습니다"));
    }

    public int getAmount() {
        return amount;
    }




}
