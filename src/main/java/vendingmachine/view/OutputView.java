package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import vendingmachine.model.Coin;
import vendingmachine.model.CustomerMoney;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.util.Notice;
import vendingmachine.view.util.Unit;

public class OutputView {

    public void printBalance(VendingMachine vendingMachine){
        printMessage(Notice.BALANCE_STATUS.getMessage() + vendingMachine.getCustomerBalance());
    }
    public void printResult(VendingMachine vendingMachine){
        printBalance(vendingMachine);

    }
    public void printCoinStatus(VendingMachine vendingMachine){
        for(Entry<Coin, Integer> eachCoinStatus : vendingMachine.confirmCoinStatus().entrySet()){
            StringJoiner status = new StringJoiner(Unit.SEPARATE_UNIT.getUnit());
            Coin coin = eachCoinStatus.getKey();
            int coinCount = eachCoinStatus.getValue();

            status.add(coin.getName());
            status.add(Integer.toString(coinCount));
            printMessage(status.toString());
            printBlankLine();
        }
    }
    public void printBlankLine(){
        System.out.println("\n");
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
}
