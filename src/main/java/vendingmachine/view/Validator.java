package vendingmachine.view;

import java.util.List;
import vendingmachine.domain.ManuFactureProduct;
import vendingmachine.domain.Product;

public class Validator {
    private final String DELEMETER=";";
    private ManuFactureProduct manuFactureProduct;

    public Validator() {
        this.manuFactureProduct = new ManuFactureProduct();
    }

    public int validateChanges(String readChanges) {
        int changes = convertChangesStringToInt(readChanges);
        validateDivisibleByUnit(changes);
        return changes;
    }

    private void validateDivisibleByUnit(int changes) {
        if(changes%10>0){
            throw new IllegalArgumentException("[ERROR] 모든 금액은 10원 단위로 나뉘어져야 합니다.");
        }
    }

    private int convertChangesStringToInt(String readChanges) {
        int changes;
        try{
            changes=Integer.parseInt(readChanges);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 잔돈으로는 숫자가 와야 합니다.");
        }
        return changes;
    }

    public List<Product> validateProduct(String readProduct) {
        long count = readProduct.chars().boxed().filter(c -> c==';').count();
        List<String> split = List.of(readProduct.split(DELEMETER));
        validateDelemeter(count,split);
        return manuFactureProduct.manufactureReadProduct(split);
    }




    private void validateDelemeter(long count, List<String> split) {
        if(count != split.size()-1){
            throw new IllegalArgumentException("[ERROR] 구분자에 의하여 상품 입력을 구분해줘야 합니다.");
        }
    }

    public int validateInputMoney(String readInputMoney) {
        int inputMoney = convertInputMoneyStringToInt(readInputMoney);
        validateDivisibleByUnit(inputMoney);
        return inputMoney;
    }

    private int convertInputMoneyStringToInt(String readInputMoney) {
        int inputMoney;
        try{
            inputMoney=Integer.parseInt(readInputMoney);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 투입 금액으로는 숫자가 와야 합니다.");
        }
        return inputMoney;
    }

}
