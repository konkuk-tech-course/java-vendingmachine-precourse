package vendingmachine.view;// @ author ninaaano

import vendingmachine.view.costant.Message;

public class InputView {
    public static void requestMachineCoinsAmount(){
        System.out.println(Message.INPUT_MACHINE_GET_COINS.getMessage());
    }
    public static void requestItems(){
        System.out.println(Message.INPUT_INSERT_PRODUCT.getMessage());
    }
    public static void requestInputCoins() {
        System.out.println(Message.INPUT_INSERT_COINS.getMessage());
    }

    public static void requestPurchaseItem() {
        System.out.println(Message.INPUT_USER_BUY_PRODUCT.getMessage());
    }}
