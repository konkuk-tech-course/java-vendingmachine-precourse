package vendingmachine.view;

import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class OutputView {

    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputReadChanges() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void printCoinMap(Map<Integer, Integer> coinMap, List<Integer> coinList) {
        System.out.println("자판기가 보유한 동전");
        for(int coin : coinList){
            System.out.printf("%d원 - %d개\n", coin, coinMap.get(coin));
        }
    }
}
