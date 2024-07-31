package AccountCard.model;

import AccountCard.enums.Currency;
import AccountCard.exceptions.CardNotValidException;
import AccountCard.exceptions.NotEnoughFundsException;

public class Account {
    private String accountNumber;
    private String fullName;
    private Currency currency;
    private double balance;

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //added a second argument amount, due to requirement of message format containing a certain amount that is added,
    //thus giving more flexibility in terms of what amount is to be chosen
    //otherwise it would have to have been fixed to 100.05
    public void addBalance(Card card, double amount) {
        if (!card.isValid()) {
            throw new CardNotValidException("The card is expired!");
        } else {
            balance += amount;
            System.out.println(amount + " " + currency.getSymbol() + " added from Card with number " + card.getCardNumber() + " from provider "
                    + card.getProvider() + " to  account with number " + accountNumber);
        }
    }

    public void exchangeFromAccount(Account account, double amount) {
        if (account.balance >= amount) {
            account.balance = account.balance - amount;
            this.balance = this.balance + amount;
        } else {
            throw new NotEnoughFundsException("Not enough funds to perform the transaction!");
        }
    }

    public void payBill(double billAmount) {
        if (this.balance >= billAmount) {
            this.balance = this.balance - billAmount;
        } else {
            throw new NotEnoughFundsException("Not enough funds to perform the transaction!");
        }
    }

    public String getBalanceString() {
        return fullName + "'s account with number " + accountNumber + " has " + balance + " " + currency;
    }

    String getFullName() {
        return fullName;
    }

    String getAccountNumber() {
        return accountNumber;
    }
}	