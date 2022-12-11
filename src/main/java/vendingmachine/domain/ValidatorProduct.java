package vendingmachine.domain;

import java.util.List;
import vendingmachine.domain.constant.ProductException;

public class ValidatorProduct {

    private final char CHARACTER_WRAPPER_PREFIX ='[';
    private final char CHARACTER_WRAPPER_SUFFIX =']';
    private final String SPLIT_COMMA=",";
    public void wrapperNotCover(String commaSplit) {
        long count = commaSplit.chars().filter(c -> c == CHARACTER_WRAPPER_PREFIX
            || c == CHARACTER_WRAPPER_SUFFIX).count();
        if (count != 2) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_WRAPPER_NOT_COVER.message());
        }
    }

    public void wrapperCoverFirstAndLast(String commaSplit) {
        if (commaSplit.charAt(0) != CHARACTER_WRAPPER_PREFIX
            || commaSplit.charAt(commaSplit.length() - 1) != CHARACTER_WRAPPER_SUFFIX) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_WRAPPER_NOT_COVER_FIRST_LAST.message());
        }
    }


    public int validateProductQuantity(String readProductQuantity) {
        int convertProductQuantity = 0;
        try {
            convertProductQuantity = Integer.parseInt(readProductQuantity);
            validatePositiveQuantity(convertProductQuantity);
        } catch (Exception e) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_QUANTITY_NO_POSITIVE.message());
        }
        return convertProductQuantity;
    }

    public void validatePositiveQuantity(int convertProductQuantity) {
        if(convertProductQuantity<=0){
            throw new IllegalArgumentException();
        }
    }

    public int validateProductValue(String readProductValue) {
        int convertProductValue = 0;
        try {
            convertProductValue = Integer.parseInt(readProductValue);
            validatePositiveValue(convertProductValue);
        } catch (Exception e) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_VALUE_NO_POSITIVE.message());
        }
        return validateUnitValue(convertProductValue);
    }

    public void validatePositiveValue(int convertProductValue) {
        if(convertProductValue<=0){
            throw new IllegalArgumentException();
        }
    }

    public int validateUnitValue(int convertProductValue) {
        if (convertProductValue % 10 > 0) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_VALUE_WRONG_UNIT.message());
        }
        return convertProductValue;
    }

    public List<String> validateSplitComma(String deleteWrapper) {
        List<String> commaSplit = List.of(deleteWrapper.split(SPLIT_COMMA));
        if (commaSplit.size() != 3) {
            throw new IllegalArgumentException(ProductException.PRODUCT_EXCEPTION_SPLIT_COMMA.message());
        }
        return commaSplit;
    }
}
