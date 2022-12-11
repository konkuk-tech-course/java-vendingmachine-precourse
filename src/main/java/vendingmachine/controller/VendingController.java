package vendingmachine.controller;

import jdk.jshell.EvalException;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.Validator;

public class VendingController {

    private InputView inputView;
    private OutputView outputView;
    private Validator validator;

    public VendingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator= new Validator();
    }

    public void activate(){
        controlReadChanges();


    }

    private void controlReadChanges() {
        try{
             validator.validateChanges(inputView.readChanges());
        }catch (IllegalArgumentException e){
            outputView.printException(e.getMessage());
        }
    }


}
