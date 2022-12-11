package vendingmachine.view.costant;// @ author ninaaano

public enum OutputVIewMessage {
    /**
     * 500원 - 0개
     * 100원 - 4개
     * 50원 - 1개
     * 10원 - 0개
     */

    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int coin;
    private int count;
    private final String coinUnit = "원 - ";
    private final String countUnit = "개";

    OutputVIewMessage(final int coin, int count) {
        this.coin = coin;
        this.count = count;
    }

    public int getCoin() {
        return coin;
    }

    public void setCount(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return coin + coinUnit + count + countUnit;
    }
}
