package vendingmachine.util.validator;// @ author ninaaano

import vendingmachine.view.OutputView;

public class CoinValidator extends Validator{
    public static void isRightCoin(String input) throws IllegalArgumentException{
        isEmpty(input);
        isNumber(input);
        isPositive(input);
        isDivisible(input);
    }
}
