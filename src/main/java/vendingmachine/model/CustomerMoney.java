package vendingmachine.model;

import vendingmachine.model.util.MachineErrors;

public class CustomerMoney {

    private int money ;

    CustomerMoney(int inputMoney){
        money = inputMoney;
    }

    public int getBalance(){
        return money;
    }

    void buy(int merchandisePrice){
        if(!canBuy(merchandisePrice)){
            throw new IllegalArgumentException(MachineErrors.LACK_OF_BALANCE.getMessage());
        }
        money -= merchandisePrice;
    }
    boolean canBuy(int merchandisePrice){
        return money >= merchandisePrice;
    }


}
