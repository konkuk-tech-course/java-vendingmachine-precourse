package vendingmachine.view.util;

public enum Commands {
    REQUEST_FOUNDATION("자판기가 보유하고 있는 금액을 입력해 주세요."),
    REQUEST_MERCHANDISE("상품명과 가격, 수량을 입력해 주세요."),
    REQUEST_INPUT_MONEY("투입 금액을 입력해 주세요."),
    REQUEST_PURCHASE("구매할 상품명을 입력해 주세요."),
    COIN_STATUS("자판기가 보유한 동전"),
    RESULT_CHANGE("잔돈");

    private final String message;

    Commands(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
