package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import jdk.jshell.EvalException;
import vendingmachine.Coin;
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
        Map<Integer, Integer> coinMap = changeGenerator.generate(changes,initCoinList());
        outputView.printCoinMap(coinMap,initCoinList());

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

    private List<Integer> initCoinList() {
        return Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(), Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount());
    }


}
