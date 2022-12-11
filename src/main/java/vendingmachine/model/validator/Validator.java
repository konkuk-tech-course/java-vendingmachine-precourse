package vendingmachine.model.validator;

import vendingmachine.model.validator.util.ValidateErrors;

public class Validator {
    void validate(String inputValue){
        validateIsBlank(inputValue);
    }
    private void validateIsBlank(String inputValue){
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(ValidateErrors.BLANK.getMessage());
        }
    }
}
