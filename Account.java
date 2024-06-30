import java.util.*;

class Account {
	 List<Card> accountCards = new ArrayList<>();
	private int accountNumber;
	private String fullName;
	private  int balance;
	 enum currencySymbol {$, €, лв};
	currencySymbol cSymb;
	
	Account() {

	}	
	
	void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	void setCurrencySymbol(currencySymbol symbol) {
		cSymb = symbol;
	}
	
	currencySymbol getCurrencySymbol() {
		return cSymb;
	}
	
	String getFullName() {
		return fullName;
	}
	
	int getAccountNumber() {
		return accountNumber;
	}
	
	 int getAccountBalance() {
		balance = 0;
		for(Card c:accountCards) {
			balance = balance + c.getAmount();
		}
		return balance;
	}
	
	String getBalanceString() {
		return fullName + "'s account with number " + String.valueOf(accountNumber) + " has " + String.valueOf(getAccountBalance()) + " " +  cSymb.toString();
	}
	
	void addCard(Card card) {
		accountCards.add(card);
	}
	
	Card findCardByNumber(int number) {		
		for(Card c:accountCards) {
			if(c.getNumber() == number) {
				return c;
			} 		
		}
	  System.out.println("Card not found for this account");
	  return null;
	}
	
	void exchangeFromAccount(Card cardHolder, Account account, Card cardRecipient, int amount) {
		if(account.findCardByNumber(cardRecipient.getNumber()) != null) {
				cardRecipient.addAmountFromCard(cardHolder,cardRecipient,amount);
				if(cardRecipient.isValid() == true) {
					System.out.println(amount + " " + cSymb.toString() + " added from card with number "
					+ " that belongs to " + getFullName() + "'s " + "account"
					+ " to " + account.getFullName() + "'s " + " account " 
					+ cardHolder.getNumber() + " with provider " 
					+ cardHolder.getProvider().toString() + " and card number " + cardRecipient.getNumber());
				}
			}
		}
	void payBill(Card cardHolder, int amount) {
		if(findCardByNumber(cardHolder.getNumber()) != null) {
			cardHolder.withrawAmountFromCard(cardHolder, amount);
			if(cardHolder.isValid() == true) {
				System.out.println(amount + " " + cSymb.toString() 
				    + " bill paid from " + getFullName() + "'s account"
                    + " with and card number " + cardHolder.getNumber()
					+ " and provider " + cardHolder.getProvider());				
			}
		}
	}
}	