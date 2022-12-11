package vendingmachine.view;

public class Validator {

    public int validateChanges(String readChanges) {
        int changes = convertNumber(readChanges);
        validateDivisibleByUnit(changes);
        return changes;
    }

    private void validateDivisibleByUnit(int changes) {
        if(changes%10>0){
            throw new IllegalArgumentException("[ERROR] 잔돈으로 10원 단위로 나뉘어져야 합니다.");
        }
    }

    private int convertNumber(String readChanges) {
        int changes;
        try{
            changes=Integer.parseInt(readChanges);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 잔돈으로는 숫자가 와야 합니다.");
        }
        return changes;
    }
}
