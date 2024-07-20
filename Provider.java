public enum Provider {
    MASTERCARD("MasterCard"), VISA("Visa");
    private String provider;

    Provider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
}
