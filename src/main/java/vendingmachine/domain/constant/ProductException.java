package vendingmachine.domain.constant;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.Product;

public enum ProductException {

    PRODUCT_EXCEPTION_NO_REMAIN("[ERROR] 해당 상품이 남아있지 않습니다."),
    PRODUCT_EXCEPTION_NO_PRODUCT("[ERROR] 해당 상품이 존재하지 않습니다."),

    PRODUCT_EXCEPTION_WRAPPER_NOT_COVER("[ERROR] 상품은 [ : 1개 ] : 1개로 묶어서 입력해야합니다."),

    PRODUCT_EXCEPTION_WRAPPER_NOT_COVER_FIRST_LAST("[ERROR] 상품을 구분할 때는 맨 앞과 뒤에 대괄호([])로 구분해줘야 합니다."),

    PRODUCT_EXCEPTION_QUANTITY_NO_POSITIVE("[ERROR] 수량으로는 양수의 숫자가 와야 합니다."),

    PRODUCT_EXCEPTION_VALUE_NO_POSITIVE("[ERROR] 금액으로는 양수의 숫자가 와야 합니다."),

    PRODUCT_EXCEPTION_VALUE_WRONG_UNIT("[ERROR] 10원 단위의 금액이여야 합니다."),

    PRODUCT_EXCEPTION_SPLIT_COMMA("[ERROR] ,로 상품명, 가격, 수량을 구분받아야 합니다.");



    private String exception;

    ProductException(String exception) {
        this.exception = exception;
    }

    public String message() {
        return exception;
    }
}
