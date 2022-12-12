package vendingmachine.domain;// @ author ninaaano

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {

    private final Map<String, Item> items = new HashMap<>();
    public void addItems(Map<String, Item> items) {
        for(String itemName: items.keySet()){
            Item item = items.get(itemName);
            this.items.put(itemName,item);
        }
    }
}
