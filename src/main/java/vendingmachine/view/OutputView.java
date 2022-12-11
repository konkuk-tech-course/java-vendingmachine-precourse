package vendingmachine.view;

import java.util.List;
import java.util.Map;
import javax.swing.text.View;
import vendingmachine.Coin;
import vendingmachine.view.constant.ViewConstant;

public class OutputView {

    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputReadChanges() {
        System.out.println(ViewConstant.INPUT_CHANGE_MONEY.message());
    }

    public void printCoinMap(Map<Integer, Integer> coinMap, List<Integer> coinList) {
        System.out.println(ViewConstant.START_COIN_MAP.message());
        for(int coin : coinList){
            System.out.printf(ViewConstant.CHANGE_LIST.message(), coin, coinMap.get(coin));
        }
    }

    public void printInputProduct() {
        System.out.println(ViewConstant.INPUT_PRODUCT.message());
    }

    public void printInputReadInputMoney() {
        System.out.println(ViewConstant.INPUT_READ_MONEY.message());
    }

    public void printHandOverChange(int amount, int coinCount) {
        System.out.printf(ViewConstant.HAND_OVER_CHANGE.message(), amount,coinCount);
    }

    public void printRemainInputMoney(int inputMoney) {
        System.out.printf(ViewConstant.INPUT_REMAIN_MONEY.message(), inputMoney);
    }

    public void printInputConsumeProduct() {
        System.out.println(ViewConstant.INPUT_CONSUME_PRODUCT.message());
    }

    public void printLastRemainInputMoney(int inputMoney) {
        System.out.printf(ViewConstant.REMAIN_MONEY.message(),inputMoney);
        System.out.println(ViewConstant.CHANGE_MONEY.message());
    }
}
