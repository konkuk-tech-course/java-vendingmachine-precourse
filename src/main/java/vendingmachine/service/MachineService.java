package vendingmachine.service;// @ author ninaaano

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.Machine;
import vendingmachine.repository.MachineRepository;
import vendingmachine.util.generator.CoinGenerator;

import java.util.Map;
import java.util.SortedMap;

public class MachineService {

    MachineRepository machineRepository = new MachineRepository();

    public void addCoins(Long id, Integer totalCoin) {
        Machine machine = machineRepository.findById(id);
        machine.addCoins(CoinGenerator.generate(Coin.getCoinList(),totalCoin));
    }

    public Long generate(){
        return machineRepository.generate();
    }

    public SortedMap<Coin,Integer> getCoins(Long id){
        Machine machine = machineRepository.findById(id);
        return machine.getCoins();
    }


    public void addItem(Long id, Map<String, Item> items) {
        Machine machine = machineRepository.findById(id);
        machine.addItems(items);
    }
}
