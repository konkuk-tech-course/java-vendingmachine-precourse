package vendingmachine.model.validator;

import vendingmachine.model.validator.util.ValidateErrors;

public class PriceValidator extends Validator{
    @Override
    public void validate(String inputValue) {
        super.validate(inputValue);
        String trimValue = inputValue.trim();
        validateIsDigit(trimValue);
        validateCanDividedByTen(trimValue);
    }

    private void validateIsDigit(String inputValue){
        if (!inputValue.matches("\\d")) {
            throw new IllegalArgumentException(ValidateErrors.NOT_NUMBER.getMessage());
        }
    }
    private void validateCanDividedByTen(String inputValue){
        if(Integer.parseInt(inputValue)%10 != 0){
            throw new IllegalArgumentException(ValidateErrors.UNABLE_DIVIDED.getMessage());
        }
    }
}
