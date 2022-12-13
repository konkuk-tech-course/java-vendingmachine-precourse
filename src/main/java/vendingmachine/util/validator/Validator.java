package vendingmachine.util.validator;// @ author ninaaano


public class Validator {
    public static void isDivisible(String input) {
        if(Integer.parseInt(input) % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 돈은 10원으로 나누어 떨어져야 합니다");
        }
    }

    public static void isPositive(String input) {
        if(Integer.parseInt(input) < 0){
            throw new IllegalArgumentException("[ERROR] 0 이상의 수를 입력해주세요");
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public static void isEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
    }
}
