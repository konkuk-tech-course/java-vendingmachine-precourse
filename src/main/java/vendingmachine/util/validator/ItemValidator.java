package vendingmachine.util.validator;// @ author ninaaano

import vendingmachine.util.parser.costant.ParserMessage;

public class ItemValidator extends Validator {

    public static void isRightItemInput(String input) throws IllegalArgumentException {
        isEmpty(input);
        isRightItems(input);
    }

    private static void isRightItems(String input) {
        String[] items = input.split(ParserMessage.SEMI_COLON.getMessage());
        for (String item : items) {
            isRightItem(item);
        }
    }

    private static void isRightItem(String item) {
        isContainsBracketAndThrowException(item, item.length());
        String[] itemInfos = item.split(ParserMessage.COMMA.getMessage());
        isContainsAllItemInfosAndThrowsException(itemInfos);
        isRightPrice(itemInfos[1]);
        isRightQuantity(itemInfos[2]);
    }

    private static void isRightQuantity(String quantitiy) {
        try {
            isNumber(quantitiy);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 수량에 숫자를 입력해주세요");
        }
        isPositive(quantitiy);
    }

    private static void isRightPrice(String price) {
        try {
            isNumber(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 가격에 숫자를 입력해주세요");
        }
        isPositive(price);
        isDivisible(price);
    }

    private static void isContainsAllItemInfosAndThrowsException(String[] itemInfos) {
        try {
            isContainsAllItemInfos(itemInfos);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 상품 정보를 올바르게 입력해주세요");
        }

    }

    private static boolean isContainsAllItemInfos(String[] itemInfos) {
        return itemInfos.length == 3;
    }

    private static void isContainsBracketAndThrowException(String item, int length) {
        if (!isContainsBracket(item, length)) {
            throw new IllegalArgumentException("[ERROR] 상품 정보를 올바르게 입력해주세요");
        }
    }

    private static boolean isContainsBracket(String item, int length) {
        return item.indexOf('[') == 0 && item.lastIndexOf(']') == length - 1;
    }
}
