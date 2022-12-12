package vendingmachine.model;// @ author ninaaano

public class VendingMachine {
    MachineMoney machineMoney;

    public void setMachineMoney(int money)throws IllegalArgumentException{
        machineMoney = new MachineMoney(money);
    }
}
