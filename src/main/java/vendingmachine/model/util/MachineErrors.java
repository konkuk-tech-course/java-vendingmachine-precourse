package vendingmachine.model.util;

public enum MachineErrors {

    LACK_OF_BALANCE("[ERROR] 해당 상품을 구매할 수 없습니다."),
    DOES_NOT_EXIST("[ERROR] 해당 상품이 존재하지 않습니다."),
    NO_STOCK("[ERROR] 해당 상품의 재고가 없습니다.");

    private final String message ;

    MachineErrors(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
