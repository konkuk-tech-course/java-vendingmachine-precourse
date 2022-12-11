package vendingmachine.model;

import vendingmachine.model.util.MachineErrors;

public class Merchandise implements Comparable<Merchandise>{
    private final String name ;
    private final int price ;
    private int stock ;

    Merchandise(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void sell(){
        if(!canSell()){
            throw new IllegalArgumentException(MachineErrors.NO_STOCK.getMessage());
        }
        stock--;
    }

    private boolean canSell(){
        return stock > 0;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public int compareTo(Merchandise merchandise) {
        return Integer.compare(this.price, merchandise.price);
    }
}
