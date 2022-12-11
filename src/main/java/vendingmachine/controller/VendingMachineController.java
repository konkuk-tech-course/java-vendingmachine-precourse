package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController {

    public void run() {
        InputView inputView = new InputView();
        int money = inputView.readVendingMachineMoney();
        VendingMachine machine = new VendingMachine(money);
        machine.generateRandomCoin();

    }
}
