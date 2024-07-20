enum Currency {
    USD("$"), EUR("€"), BGN("лв.");
    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}