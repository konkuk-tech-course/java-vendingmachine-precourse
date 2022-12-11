package vendingmachine.view.costant;// @ author ninaaano

public enum InputViewMessage {
    INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_MACHINE_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY("투입 금액을 입력해 주세요."),
    INPUT_BUY_PRODUCT("구매할 상품명을 입력해 주세요."),
    ;


    private String message;

    InputViewMessage(String message) {
    }

    public String getMessage() {
        return message;
    }
}
