package vendingmachine.controller;

import java.util.Map;
import jdk.jshell.EvalException;
import vendingmachine.domain.ChangeGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.Validator;

public class VendingController {

    private InputView inputView;
    private OutputView outputView;
    private Validator validator;
    private ChangeGenerator changeGenerator;

    public VendingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator= new Validator();
        this.changeGenerator = new ChangeGenerator();
    }

    public void activate(){
        int changes = controlReadChanges();
        Map<Integer, Integer> coinMap = changeGenerator.generate(changes);


    }

    private int controlReadChanges() {
        int changes=0;
        outputView.printInputReadChanges();
        try{
            changes = validator.validateChanges(inputView.readChanges());
        }catch (IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return controlReadChanges();
        }
        return changes;
    }


}
