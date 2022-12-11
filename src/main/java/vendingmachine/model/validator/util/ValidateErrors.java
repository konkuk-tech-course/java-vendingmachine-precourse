package vendingmachine.model.validator.util;

public enum ValidateErrors {
    BLANK("[ERROR] 공백은 허용되지 않는다."),
    NOT_NUMBER("[ERROR] 이름은 5자 이하여야 한다."),
    UNABLE_DIVIDED("[ERROR] 금액은 10원으로 나누어져야 합니다.");

    private final String message ;

    ValidateErrors(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
