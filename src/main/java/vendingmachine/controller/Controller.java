package vendingmachine.controller;// @ author ninaaano

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.service.MachineService;
import vendingmachine.util.parser.ItemParser;
import vendingmachine.util.parser.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;

public class Controller {
    MachineService machineService = new MachineService();
    public void run() {
        Long machineId = machineService.generate();
        inputCoinsToMachineByManager(machineId);
        inputItemsToMachineByManager(machineId);
        inputCoinsToMachineByUser(machineId);
    }


    /**
     * 투입 금액을 입력해 주세요. > 입력 메세지 출력
     * 3000 > 입력 받기
     * ------------------ 완료
     *
     * 투입 금액: 3000원 > 입력한 금액 출력
     * 구매할 상품명을 입력해 주세요. > 메세지 출력
     * 콜라 > 입력받기
     * @param machineId
     */
    private void inputCoinsToMachineByUser(Long machineId) {
        InputView.requestInputCoins(); // 사용자 입력
        machineService.addInputCoins(machineId,getInputCoinsByUser());
    }

    // 사용자 투입금액 입력을 받는 부분
    private Integer getInputCoinsByUser() {
        try{
            return Parser.covertStringToInt(Console.readLine());
        }catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return getInputCoinsByUser();
        }
    }

    private void inputItemsToMachineByManager(Long machineId) {
        InputView.requestItems();
        machineService.addItem(machineId,getItemsByManager());
    }

    private Map<String, Item> getItemsByManager() {
        try {
            return ItemParser.getItems(Console.readLine());
        }catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return getItemsByManager();
        }
    }

    private void inputCoinsToMachineByManager(Long machineId) {
        InputView.requestMachineCoinsAmount();
        machineService.addCoins(machineId, getCoinAmountByUser());
        OutputView.printMachineGetCoins();
        OutputView.printMachineCoins(machineService.getCoins(machineId));
    }

    private int getCoinAmountByUser() {
        try {
            return Parser.covertStringToInt(Console.readLine());
        }catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return getCoinAmountByUser();
        }
    }


}
