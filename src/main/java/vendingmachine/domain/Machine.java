package vendingmachine.domain;// @ author ninaaano

import java.util.Map;
import java.util.SortedMap;

public class Machine {

    CoinStorage coinStorage = new CoinStorage();
    ItemStorage itemStorage = new ItemStorage();


    public SortedMap<Coin, Integer> getCoins() {
        return coinStorage.getCoins();
    }

    public void addCoins(SortedMap<Coin,Integer> coins) {
        coinStorage.addCoins(coins);
    }

    public void addItems(Map<String, Item> items) {
        itemStorage.addItems(items);
    }

    public void addInputCoinAmount(final int amount) {
        coinStorage.addInputCoinAmount(amount);
    }

    public Boolean isPurchasable() {
        if(itemStorage.checkInputCoinAmountByMinPrice(getInputCoinAmount()))
            return false;
        return !itemStorage.isAllItemSoldOut();
    }

    public int getInputCoinAmount() {
        return coinStorage.getInputCoinAmount();
    }

    public void purchase(String itemName) throws IllegalArgumentException{
        Item item = itemStorage.get(itemName);
        validatePurchase(item);
        coinStorage.decreaseInputCoinAmount(item.getPrice());
    }

    private void validatePurchase(Item item) {
        itemStorage.isNoItem(item);
        itemStorage.checkInputCoinAmountByItem(item, getInputCoinAmount());
        item.decreaseQuantity();
    }

}
