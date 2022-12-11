package vendingmachine.view.util;

public enum Notice {
    COIN_STATUS("자판기가 보유한 동전"),
    BALANCE_STATUS("투입 금액 : "),
    RESULT_CHANGE("잔돈");

    private final String message;

    Notice(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
