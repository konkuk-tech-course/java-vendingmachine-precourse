package vendingmachine.model;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String INVALID_COMMAND_MESSAGE = "[ERROR] 해당 금액의 동전을 찾을 수 없습니다." ;
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현

    public String getName(){
        return amount+"원";
    }
    public int getAmount(){
        return amount;
    }

    public static Coin by(int amount){
        return Arrays.stream(values())
                .filter(coin -> amount == coin.getAmount())
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }
}
