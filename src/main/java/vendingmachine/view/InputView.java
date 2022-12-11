package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.Validator;
import vendingmachine.utils.Util;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int money = Util.convertStringToInt(Console.readLine());
        Validator.validateMachineMoney(money);
        return money;
    }

    public List<Product> readProductInfo() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String productListInfo = Console.readLine();
        Validator.validateProductFormat(productListInfo);
        return Util.convertProductListToProduct(productListInfo);
    }

    public static void main(String[] args) {
        String productInfo = "[콜라,1500,20];[사이다,1000,10]";
        Arrays.stream(productInfo.split(";")).forEach(System.out::println);
    }
}
