package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManuFactureProduct {

    private final String WRAPPER_PREFIX="[";
    private final String WRAPPER_SUFFIX="]";

    Map<String, Product> productMap;
    ValidatorProduct validatorProduct ;



    public ManuFactureProduct() {
        this.productMap = new HashMap<>();
        this.validatorProduct = new ValidatorProduct();
    }

    public Map<String, Product> manufactureReadProduct(List<String> split) {
        for (int i = 0; i < split.size(); i++) {
            validateWrapper(split.get(i));
            String deleteWrapper = replaceWrapper(split.get(i));
            List<String> commaSplit = validatorProduct.validateSplitComma(deleteWrapper);
            addProduct(commaSplit);
        }
        return productMap;
    }
    private void addProduct(List<String> commaSplit) {
        Product product = makeProduct(commaSplit);
        productMap.put(commaSplit.get(0), product);
    }

    private Product makeProduct(List<String> commaSplit) {
        return new Product(commaSplit.get(0), validatorProduct.validateProductValue(commaSplit.get(1)),validatorProduct.validateProductQuantity(commaSplit.get(2)));
    }

    private String replaceWrapper(String s) {
        String replace = s.replace(WRAPPER_PREFIX, "");
        replace = replace.replace(WRAPPER_SUFFIX, "");
        return replace;
    }


    private void validateWrapper(String commaSplit) {
        validatorProduct.wrapperNotCover(commaSplit);
        validatorProduct.wrapperCoverFirstAndLast(commaSplit);
    }


}
