package vendingmachine.view;// @ author ninaaano

import vendingmachine.view.costant.ViewMessage;

public class InputView {
    public static void requestMachineCoinsAmount(){
        System.out.println(ViewMessage.INPUT_MACHINE_GET_COINS.getMessage());
    }
    public static void requestItems(){
        System.out.println(ViewMessage.INPUT_INSERT_PRODUCT.getMessage());
    }
    public static void requestInputCoins() {
        System.out.println(ViewMessage.INPUT_INSERT_COINS.getMessage());
    }

    public static void requestPurchaseItem() {
        System.out.println(ViewMessage.INPUT_USER_BUY_PRODUCT.getMessage());
    }}
