package vendingmachine.view.constant;

public enum ViewConstant {

    START_COIN_MAP("자판기가 보유한 동전"),
    CHANGE_LIST("%d원 - %d개\n"),
    INPUT_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_READ_MONEY("투입 금액을 입력해 주세요."),
    HAND_OVER_CHANGE("%d원-%d개\n"),
    INPUT_REMAIN_MONEY("투입 금액: %d원\n"),
    INPUT_CONSUME_PRODUCT("구매할 상품명을 입력해 주세요."),
    REMAIN_MONEY("투입 금액: %d원\n"),
    INPUT_CHANGE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    CHANGE_MONEY("잔돈");


    private String message;

    ViewConstant(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
