package vendingmachine.model.validator.util;

public enum ValidateErrors {
    BLANK("[ERROR] 공백은 허용되지 않는다.");

    private final String message ;

    ValidateErrors(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
