package AccountCard.enums;

public enum Currency {
    USD("$"), EUR("€"), BGN("лв.");
    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    //has 1 usage in Account class line 33
    public String getSymbol() {
        return symbol;
    }
}