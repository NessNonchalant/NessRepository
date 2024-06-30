import java.util.*;
import java.time.*;
import java.io.*;

class Card {
	//
	Card () {
		
	};
	private LocalDate expiryDate;
	private int number;
	private int amount;
	enum provider{MASTERCARD, VISA, AMERICANPEXPRESS, DISCOVER};	
	provider pVider;
	
	boolean isValid() {
		int result = expiryDate.compareTo(LocalDate.now());
		if(result < 0) {
			return false;
		}
		return true;
	}
	
	void setNumber(int number) {
		this.number = number;
	}
	
	void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	void setAmount(int amount) {
		this.amount = amount;
	}
	
	void setProvider(provider prov) {
		pVider = prov;
	}
	
	provider getProvider() {
		return pVider;
	}
	
	int getNumber() {
		return number;
	}
	
	int getAmount() {
		return amount;
	}
	
	LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	void addAmountFromCard(Card cardHolder, Card cardRecipient, int amount) {			
		try {
			if( cardRecipient.isValid() == false ) {
				throw new CardNotValidException("The card with number " + cardRecipient.getNumber() + " is expired ");
			} else
			cardRecipient.amount = cardRecipient.amount + amount;
			cardHolder.amount = cardHolder.amount - amount;
		}catch(CardNotValidException e) {
			System.out.println("Message:" + e.getMessage());
		}				
	}
	void withrawAmountFromCard(Card cardHolder, int amount) {			
		try {
			if(cardHolder.isValid() == false) {
				throw new CardNotValidException("The card with number " + cardHolder.getNumber() + " is expired ");
			} else
			cardHolder.amount = cardHolder.amount - amount;
		}catch(CardNotValidException e) {
			System.out.println("Message:" + e.getMessage());
		}				
	}
}
