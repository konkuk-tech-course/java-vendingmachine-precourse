package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Merchandise;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineProgram {

    private VendingMachine vendingMachine ;
    private final InputView in;
    private final OutputView out;

    public VendingMachineProgram(){
        out = new OutputView();
        in = new InputView(out);
    }
    public void run(){
        setDefault();
        out.printCoinStatus(vendingMachine);
        while (vendingMachine.checkIsPurchasable()){
            String wantToBuy = in.readItemToBuy();
            startBuy(wantToBuy);
        }
        out.printResult(vendingMachine);
    }
    private void setDefault(){
        int foundation = in.readFoundation();
        List<Merchandise> merchandises = in.readMerchandises();
        vendingMachine = new VendingMachine(foundation, merchandises);
    }
    private void startBuy(String wantToBuy){
        vendingMachine.sale(wantToBuy);
    }
}
