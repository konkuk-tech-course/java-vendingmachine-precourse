package vendingmachine.view;// @ author ninaaano


import vendingmachine.view.costant.Message;
import vendingmachine.domain.Coin;

import java.util.SortedMap;

public class OutputView {

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printMachineGetCoins(){
        System.out.println(Message.OUTPUT_MACHINE_HOLDING_COINS.getMessage());
    }

    public static void printInsertCoins(Integer amount){
        System.out.println(Message.OUTPUT_INSERT_COINS.getMessage() + amount + "원");
    }

    public static void printMachineCoins(SortedMap<Coin, Integer> coins) {
        for (Coin key : coins.keySet()) {
            System.out.println(key.getAmount() + "원 - " + coins.get(key) + "개");
        }
    }

    public static void printChanges(){
        System.out.println(Message.OUTPUT_CHANGES.getMessage());
    }
}
