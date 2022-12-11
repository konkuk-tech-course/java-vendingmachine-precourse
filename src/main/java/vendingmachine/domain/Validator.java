package vendingmachine.domain;

import static vendingmachine.Coin.COIN_10;

public class Validator {
    public static void validateMachineMoney(int money) {
        if (money % COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력하셔야합니다.");
        }
    }
}
