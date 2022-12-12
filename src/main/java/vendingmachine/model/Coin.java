package vendingmachine.model;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int amount;
    private int count;
    private final String coinUnit = "원 - ";
    private final String countUnit = "개";

    Coin(final int amount,int count) {
        this.amount = amount;
        this.count = count;
    }

    // 추가 기능 구현

    public int getCoin() {
        return amount;
    }

    public void setCount(int count){
        this.count = count;
    }

    // 이건 안쓰는게 좋음
    @Override
    public String toString() {
        return amount + coinUnit + count + countUnit;
    }
}
