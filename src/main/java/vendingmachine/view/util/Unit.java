package vendingmachine.view.util;

public enum Unit {
    MONETARY_UNIT("원"),
    SEPARATE_UNIT(" - "),
    COUNT_UNIT("개");

    private final String unit;

    Unit(String message){
        this.unit = message;
    }

    public String getUnit(){
        return unit;
    }
}
