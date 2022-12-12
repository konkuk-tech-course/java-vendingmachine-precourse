package vendingmachine.view;// @ author ninaaano

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.costant.InputViewMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {

    // 자판기 보유 금액 입력
    public int inputHoldingAmount() {
        System.out.println(InputViewMessage.INPUT_MACHINE_MONEY.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    // 상품명, 가격, 수량 입력
    public String inputProduct() {
        System.out.println(InputViewMessage.INPUT_MACHINE_PRODUCT.getMessage());
        return Console.readLine();
    }

    public static List<String> productInventory(String input) {
        List<String> object = Arrays.asList(input.split("\\[\\,\\]\\;"));
        return object;
    }

    public void test(){
        String str = "[콜라,2000,10]";
        //productInventory(str);
        System.out.println(productInventory(str));
    }


    // 투입 금액 입력

}
