package vendingmachine.util.parser.costant;// @ author ninaaano

public enum ParserMessage {
    SEMI_COLON(";"),
    LEFT_BIG_BRACKET("["),
    RIGHT_BIG_BRACKET("]"),
    COMMA(","),
    EMPTY("");

    private String message;

    ParserMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
