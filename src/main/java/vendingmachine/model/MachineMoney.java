package vendingmachine.model;// @ author ninaaano

public class MachineMoney {

    final static int MIN_COIN = 10;

    private int money;

    public MachineMoney() {
    }

    public int getMoney() {
        return money;
    }

    public MachineMoney(int money) throws IllegalArgumentException{
        this.money = money;
    }
}
