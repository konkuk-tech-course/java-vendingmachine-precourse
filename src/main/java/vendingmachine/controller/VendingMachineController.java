package vendingmachine.controller;// @ author ninaaano

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController {

    InputView inputView = new InputView();

    public void run(){
        VendingMachine vendingMachine = new VendingMachine();
        setMachineMoney(vendingMachine);
    }

    private void setMachineMoney(VendingMachine vendingMachine) {
        try {
            vendingMachine.setMachineMoney(inputView.inputHoldingAmount());
        }catch (IllegalArgumentException exception){
            System.out.println("[ERROR] 컨트롤러 setMachineMoney에서 오류 발생");
            setMachineMoney(vendingMachine);
        }
    }


}
