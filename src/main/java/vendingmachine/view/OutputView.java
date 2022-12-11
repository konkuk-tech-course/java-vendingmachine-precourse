package vendingmachine.view;

public class OutputView {

    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputReadChanges() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }
}
