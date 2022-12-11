package vendingmachine.model.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PriceValidatorTest {

    private static final PriceValidator priceValidator = new PriceValidator();

    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "  ",
            "a",
            "100d",
            "fuck"
    })
    void validateTest(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> priceValidator.validate(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}