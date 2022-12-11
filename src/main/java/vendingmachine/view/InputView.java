package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import vendingmachine.model.Merchandise;
import vendingmachine.model.validator.NameValidator;
import vendingmachine.model.validator.PriceValidator;
import vendingmachine.model.validator.SeparatorValidator;

public class InputView {
    private final PriceValidator priceValidator = new PriceValidator();
    private final NameValidator nameValidator = new NameValidator();
    private final SeparatorValidator separatorValidator = new SeparatorValidator();
    private final OutputView out ;
    public InputView(OutputView outputView){
        out = outputView;
    }
    public int readFoundation(){
        String inputMoney = Console.readLine();
        try {
            priceValidator.validate(inputMoney);
            return Integer.parseInt(inputMoney.trim());
        } catch (IllegalArgumentException e) {
            out.printMessage(e.getMessage());
        }
        return -1;
    }
    public int readInputMoney(){
        String inputMoney = Console.readLine();
        try {
            priceValidator.validate(inputMoney);
            return Integer.parseInt(inputMoney.trim());
        } catch (IllegalArgumentException e) {
            out.printMessage(e.getMessage());
        }
        return -1;
    }
    public String readItemToBuy(){
        return "";
    }
    public List<Merchandise> readMerchandises(){
        return new ArrayList<>();
    }

//    public Optional<List<>>
}
