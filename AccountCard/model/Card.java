package AccountCard.model;

import AccountCard.enums.Provider;

import java.time.LocalDate;

public class Card {
    private Provider provider;
    private LocalDate expiryDate;
    private String cardNumber;

    boolean isValid() {
        return LocalDate.now().isBefore(expiryDate);
    }

    public void setCardNumber(String number) {
        this.cardNumber = number;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    String getCardNumber() {
        return cardNumber;
    }

    Provider getProvider() {
        return this.provider;
    }
}