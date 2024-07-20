import java.util.*;
import java.time.*;
import java.io.*;

class Card {
    Card() {
    }

    private Provider provider;
    private LocalDate expiryDate;
    private String cardNumber;
    private double amount;

    boolean isValid() {
        return LocalDate.now().isBefore(expiryDate);
    }

    void setCardNumber(String number) {
        this.cardNumber = number;
    }

    void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    String getCardNumber() {
        return cardNumber;
    }

    Provider getProvider() {
        return this.provider;
    }
}