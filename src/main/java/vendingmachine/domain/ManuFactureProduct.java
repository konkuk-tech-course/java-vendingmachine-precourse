package vendingmachine.domain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ManuFactureProduct {
    List<Product> productList = new ArrayList<>();
    public List<Product> manufactureReadProduct(List<String> split) {
        for (int i = 0; i < split.size(); i++) {
            validateWrapper(split.get(i));
            String deleteWrapper = replaceWrapper(split.get(i));
            List<String> commaSplit = splitComma(deleteWrapper);
            addProduct(productList, commaSplit);
        }
        return productList;
    }

    private void addProduct(List<Product> productList, List<String> commaSplit) {
        productList.add(new Product(commaSplit.get(0), validateProductValue(commaSplit.get(1)), validateProductQuantity(
            commaSplit.get(2))));
    }

    private String replaceWrapper(String s) {
        String replace = s.replace("[", "");
        replace = replace.replace("]", "");
        return replace;
    }


    private void validateWrapper(String commaSplit) {
        wrapperNotCover(commaSplit);
        wrapperCoverFirstAndLast(commaSplit);
    }

    private void wrapperNotCover(String commaSplit) {
        long count = commaSplit.chars().filter(c -> c == '[' || c == ']').count();
        if (count != 2) {
            throw new IllegalArgumentException("[ERROR] 상품은 [ : 1개 ] : 1개로 묶어서 입력해야합니다.");
        }
    }

    private void wrapperCoverFirstAndLast(String commaSplit) {
        if (commaSplit.charAt(0) != '[' || commaSplit.charAt(commaSplit.length() - 1) != ']') {
            throw new IllegalArgumentException("[ERROR] 상품을 구분할 때는 맨 앞과 뒤에 대괄호([])로 구분해줘야 합니다.");
        }
    }


    private int validateProductQuantity(String readProductQuantity) {
        int convertProductQuantity = 0;
        try {
            convertProductQuantity = Integer.parseInt(readProductQuantity);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 수량으로는 숫자가 와야 합니다.");
        }
        return convertProductQuantity;
    }

    private int validateProductValue(String readProductValue) {
        int convertProductValue = 0;
        try {
            convertProductValue = Integer.parseInt(readProductValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액으로는 숫자가 와야 합니다.");
        }
        return validateUnitValue(convertProductValue);
    }

    private int validateUnitValue(int convertProductValue) {
        if (convertProductValue % 10 > 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위의 금액이여야 합니다.");
        }
        return convertProductValue;
    }

    private List<String> splitComma(String deleteWrapper) {
        List<String> commaSplit = List.of(deleteWrapper.split(","));
        if (commaSplit.size() != 3) {
            throw new IllegalArgumentException("[ERROR] ,로 상품명, 가격, 수량을 구분받아야 합니다.");
        }
        return commaSplit;
    }
}
