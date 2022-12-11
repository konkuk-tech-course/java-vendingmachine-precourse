package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readChanges() {
        return Console.readLine();
    }

    public String readProduct() {
        return Console.readLine();
    }

    public String readConsumeProduct() {
        return Console.readLine();
    }
}
