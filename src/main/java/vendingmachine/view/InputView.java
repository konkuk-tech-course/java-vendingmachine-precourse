package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Validator;
import vendingmachine.utils.Util;

public class InputView {

    public int readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int money = Util.convertStringToInt(Console.readLine());
        Validator.validateMachineMoney(money);
        return money;
    }
}
