package vendingmachine.utils;

import vendingmachine.domain.Product;
import vendingmachine.domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {


    public static final String DELIMITER = ",";

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
    }

    public static List<Product> convertProductListToProduct(String productListInfo) {
        return Arrays.stream(productListInfo.split(DELIMITER))
                .map(Util::convertToProduct)
                .collect(Collectors.toList());
    }

    private static Product convertToProduct(String productInfo) {
        List<String> productInfoList = Arrays.stream(bracketRemovedString(productInfo)
                .split(DELIMITER))
                .collect(Collectors.toList());
        Validator.validateProductListSize(productInfoList);
        return new Product(productInfoList);
    }

    private static String bracketRemovedString(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }

    public static void main(String[] args) {
        String productInfo = "[콜라,1500,2545640]";
        String substring = bracketRemovedString(productInfo);
        System.out.println(substring);
    }

    public static int convertStringToPrice(String message) {
        int price = Util.convertStringToInt(message);
        Validator.validatePrice(price);
        return price;
    }


}
