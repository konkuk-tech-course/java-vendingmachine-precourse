package vendingmachine.utils;

import vendingmachine.domain.Product;
import vendingmachine.domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final String PRODUCT_DELIMITER = ";";
    public static final String INFO_DELIMITER = ",";


    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
    }

    public static List<Product> convertProductListToProduct(String productListInfo) {
        return Arrays.stream(productListInfo.split(PRODUCT_DELIMITER))
                .map(Util::convertToProduct)
                .collect(Collectors.toList());
    }

    private static Product convertToProduct(String productInfo) {
        List<String> productInfoList = Arrays.stream(bracketRemovedString(productInfo)
                .split(INFO_DELIMITER))
                .collect(Collectors.toList());
        Validator.validateProductListSize(productInfoList);
        return new Product(productInfoList);
    }

    private static String bracketRemovedString(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }

    public static int convertStringToProductPrice(String message) {
        int price = Util.convertStringToInt(message);
        Validator.validatePrice(price);
        return price;
    }
}
