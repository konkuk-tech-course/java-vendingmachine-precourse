package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static vendingmachine.Coin.COIN_10;

public class Validator {
    public static final int PRODUCT_INFO_SIZE = 3;
    public static final int MIN_PRICE = 100;
    private static final String format = "^\\[[a-zA-Z0-9가-힣]+,\\d+,\\d+\\]$";

    public static void validateDividedByTen(int money) {
        if (money % COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력하셔야합니다.");
        }
    }

    public static void validateProductFormat(String productListInfo) {
        Arrays.stream(productListInfo.split(";")).forEach(Validator::isMatchesWithFormat);
    }

    private static void isMatchesWithFormat(String productInfo) {
        if (!Pattern.matches(format, productInfo)) {
            throw new IllegalArgumentException("[ERROR] Product의 형식이 잘못되었습니다.");
        }
    }

    public static void validateProductListSize(List<String> productInfoList) {
        if (productInfoList.size() != PRODUCT_INFO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 상품 형식이 잘못되었습니다.");
        }
    }

    public static void validatePrice(int price) {
        if (price <= MIN_PRICE){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100보다는 커야 합니다");
        }
        if (price % Coin.COIN_10.getAmount() != 0){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어떨어져야 한다.");
        }
    }

    public static void validateProductName(String productName, List<Product> products) {
        if(!hasAnyMatch(productName, products)){
            throw new IllegalArgumentException("[ERROR] 일치하는 상품이 없습니다.");
        }
    }

    private static boolean hasAnyMatch(String productName, List<Product> products) {
       return products.stream().map(Product::getName).anyMatch(product -> product.equals(productName));
    }
}
