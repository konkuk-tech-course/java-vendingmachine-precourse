package vendingmachine.util.parser;// @ author ninaaano

import vendingmachine.domain.Item;
import vendingmachine.util.parser.costant.ParserMessage;
import vendingmachine.util.validator.ItemValidator;

import java.util.HashMap;
import java.util.Map;

public class ItemParser extends Parser{
    public static Map<String, Item> getItems(String input) {
        ItemValidator.isRightItemInput(input);
        Map<String, Item> items = new HashMap<>();
        for(String item : input.split(ParserMessage.SEMI_COLON.getMessage())){
            item = removeBigBracket(item);
            putItemInItems(items, item);
        }
        return items;
    }

    private static void putItemInItems(Map<String, Item> items, String item) {
        String[] itemInfos = item.split(ParserMessage.COMMA.getMessage());
        items.put(itemInfos[0],new Item(itemInfos[0],Integer.parseInt(itemInfos[1]),Integer.parseInt(itemInfos[2])));
    }

    private static String removeBigBracket(String item) {
        item.replace(ParserMessage.LEFT_BIG_BRACKET.getMessage(),ParserMessage.EMPTY.getMessage());
        item.replace(ParserMessage.RIGHT_BIG_BRACKET.getMessage(),ParserMessage.EMPTY.getMessage());
        return item;
    }
}
