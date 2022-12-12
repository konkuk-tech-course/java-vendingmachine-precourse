package vendingmachine.controller;// @ author ninaaano

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.service.MachineService;
import vendingmachine.util.parser.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    MachineService machineService = new MachineService();
    public void run() {
        Long machineId = machineService.generate();
        inputCoinsToMachineByManager(machineId);
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
