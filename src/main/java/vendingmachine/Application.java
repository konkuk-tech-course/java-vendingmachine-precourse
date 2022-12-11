package vendingmachine;

import vendingmachine.controller.VendingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingController vendingController = new VendingController();
        vendingController.activate();
    }
}
