package vendingmachine.view.costant;// @ author ninaaano

public enum ViewMessage {
    INPUT_MACHINE_GET_COINS("\n자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_INSERT_PRODUCT("\n상품명과 가격, 수량을 입력해 주세요."),
    INPUT_INSERT_COINS("\n투입 금액을 입력해 주세요."),
    INPUT_USER_BUY_PRODUCT("\n구매할 상품명을 입력해 주세요."),

    OUTPUT_MACHINE_HOLDING_COINS("\n자판기가 보유한 동전"),
    OUTPUT_INSERT_COINS("\n투입 금액:"),
    OUTPUT_CHANGES("잔돈");

    private String message;


    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
