import java.math.BigDecimal;
import java.util.*;

class Account {
    private String accountNumber;
    private String fullName;
    private Currency currency;
    private double balance;

    void setCurrency(Currency currency) {
        this.currency = currency;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //added a second argument amount, due to requirement of message format containing a certain amount that is added,
    //thus giving more flexibility in terms of what amount is to be chosen
    //otherwise it would have to have been fixed to 100.05
    void addBalance(Card card, double amount) {
        if (!card.isValid()) {
            throw new CardNotValidException("The card is expired!");
        } else {
            balance = balance + amount;
            System.out.println(amount + " " + currency + " added from Card with number " + card.getCardNumber() + " from provider "
                    + card.getProvider() + " to  account with number " + accountNumber);
        }
    }

    void exchangeFromAccount(Account account, double amount) {
        if (account.balance >= amount) {
            account.balance = account.balance - amount;
            this.balance = this.balance + amount;
        } else {
            throw new NotEnoughFundsException("Not enough funds to perform the transaction!");
        }
    }

    void payBill(double billAmount) {
        if (this.balance >= billAmount) {
            this.balance = this.balance - billAmount;
        } else {
            throw new NotEnoughFundsException("Not enough funds to perform the transaction!");
        }
    }

    String getBalanceString() {
        return fullName + "'s account with number " + accountNumber + " has " + balance + " " + currency;
    }

    String getFullName() {
        return fullName;
    }

    String getAccountNumber() {
        return accountNumber;
    }
}	