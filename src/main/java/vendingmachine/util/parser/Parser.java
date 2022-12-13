package vendingmachine.util.parser;// @ author ninaaano

import vendingmachine.util.validator.CoinValidator;

public class Parser {
    public static int covertStringToInt(String input) {
        CoinValidator.isRightCoin(input);
        return Integer.parseInt(input);
    }
}
