package vendingmachine.model;

import java.util.List;
import java.util.Map;
import vendingmachine.model.generator.MachineCoinGenerator;
import vendingmachine.model.util.MachineErrors;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private static final OutputView out = new OutputView() ;
    private Map<Coin, Integer> coinStatus ;
    private List<Merchandise> merchandises ;
    private final int lowestPrice ;
    private CustomerMoney customerMoney ;

    public VendingMachine(int foundation, List<Merchandise> merchandises){
        MachineCoinGenerator coinGenerator = new MachineCoinGenerator(foundation);
        this.coinStatus = coinGenerator.settingMachineCoins();
        this.merchandises = merchandises;
        this.lowestPrice = searchLowestPrice();
    }
    private int searchLowestPrice(){
        return merchandises.stream()
                .sorted().findFirst()
                .get().getPrice();
    }

    void putCustomerMoney(int customerMoney){
        this.customerMoney = new CustomerMoney(customerMoney);
    }

    public Map<Coin, Integer> confirmCoinStatus(){
        return coinStatus;
    }
    public boolean checkIsPurchasable(){
        return getCustomerBalance() > lowestPrice;
    }
    public int getCustomerBalance(){
        return customerMoney.getBalance();
    }

    // sale 호출할 때, try catch를 사용하자.
    public void sale(String merchandiseName){
        tryToBuy(merchandiseName);
    }

    private void tryToBuy(String merchandiseName){
        Merchandise merchandise = findMerchandiseByName(merchandiseName);
        int index = merchandises.indexOf(merchandise);
        customerMoney.buy(merchandise.getPrice());
        merchandise.sell();
        merchandises.set(index, merchandise);
    }
    private Merchandise findMerchandiseByName(String merchandiseName){
        return merchandises.stream()
                .filter(merchandise -> merchandise.getName().equals(merchandiseName))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(MachineErrors.DOES_NOT_EXIST.getMessage()));
    }

}
