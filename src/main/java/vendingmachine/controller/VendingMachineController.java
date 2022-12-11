package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class VendingMachineController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
//        int money = inputView.readVendingMachineMoney();
        VendingMachine machine = new VendingMachine(1000);
        machine.convertMoneyToRandomCoin();
        System.out.println("money : " + machine.getMoney());
        System.out.println("holdingMoney : " + machine.getHoldingMoney());

        outputView.printMachineCoin(machine.getHoldingMoney());

        List<Product> products = inputView.readProductInfo();



    }

    public static void main(String[] args) {
        /*VendingMachine machine = new VendingMachine(1000);
        machine.convertMoneyToRandomCoin();
        int money = machine.getMoney();
        System.out.println("money = " + money);
        Map<Coin, Integer> holdingMoney = machine.getHoldingMoney();
        System.out.println("holdingMoney = " + holdingMoney);*/

        VendingMachineController controller = new VendingMachineController();
        controller.run();

    }
}
