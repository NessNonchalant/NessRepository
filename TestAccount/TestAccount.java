import java.util.*;
import java.time.*;

class TestAccount {
	public static void main(String[] args) {
		
	  
		
	  Card personalCard_ness = new Card();
	  Card spouseCard_ness = new Card();
	  Card childCard_ness = new Card();
	  
	  personalCard_ness.setExpiryDate(LocalDate.parse("2026-06-13"));
	  personalCard_ness.setNumber(44644235);
	  personalCard_ness.setAmount(500);
	  personalCard_ness.setProvider(personalCard_ness.pVider.valueOf("MASTERCARD"));
	  
	  spouseCard_ness.setExpiryDate(LocalDate.parse("2025-08-24"));
	  spouseCard_ness.setNumber(34563455);
	  spouseCard_ness.setAmount(200);
	  spouseCard_ness.setProvider(personalCard_ness.pVider.valueOf("VISA"));
	  
	  childCard_ness.setExpiryDate(LocalDate.parse("2026-01-11"));
	  childCard_ness.setNumber(53456545);
	  childCard_ness.setAmount(50);
	  childCard_ness.setProvider(personalCard_ness.pVider.valueOf("AMERICANPEXPRESS"));
	  
	  
	  
	  Account accountNestor = new Account();
	  accountNestor.setFullName("Nestor Svilenov Tsagov");
	  accountNestor.setCurrencySymbol(accountNestor.cSymb.valueOf("$"));
	  accountNestor.setAccountNumber(111666);
	  
	  accountNestor.addCard(personalCard_ness);
	  accountNestor.addCard(spouseCard_ness);
	  accountNestor.addCard(childCard_ness);
	  
	  Card personalCard_tomov = new Card();
	  Card spouseCard_tomov = new Card();
	  Card childCard_Tomov = new Card();
	  Account accountTomov = new Account();
	  
	  
	  
	  accountTomov.setFullName("Dimitar Dimitrov Tomov");
	  accountTomov.setAccountNumber(2345234);
	  accountTomov.setCurrencySymbol(accountTomov.cSymb.valueOf("€"));
	  
	  
	  personalCard_tomov.setExpiryDate(LocalDate.parse("2025-05-07"));
	  personalCard_tomov.setNumber(123543645);
	  personalCard_tomov.setAmount(450);
	  personalCard_tomov.setProvider(personalCard_ness.pVider.valueOf("MASTERCARD"));
	  
	  spouseCard_tomov.setExpiryDate(LocalDate.parse("2025-01-01"));
	  spouseCard_tomov.setNumber(6457666);
	  spouseCard_tomov.setAmount(250);
	  spouseCard_tomov.setProvider(personalCard_ness.pVider.valueOf("VISA"));
	  
	  childCard_Tomov.setExpiryDate(LocalDate.parse("2023-01-01"));
	  childCard_Tomov.setNumber(23452345);
	  childCard_Tomov.setAmount(100);
	  childCard_Tomov.setProvider(personalCard_ness.pVider.valueOf("VISA"));
	  
	  accountTomov.addCard(personalCard_tomov);
	  accountTomov.addCard(spouseCard_tomov);
	  accountTomov.addCard(childCard_Tomov);
	  
	  String nessBalanace = accountNestor.getBalanceString();
	  String tomovBalance = accountTomov.getBalanceString();
	  
	  System.out.println(tomovBalance);
	  System.out.println(nessBalanace);
	  
	  accountTomov.exchangeFromAccount(personalCard_tomov, // withraw
	  accountNestor,
	  personalCard_ness, //add
	  50); 

	  nessBalanace = accountNestor.getBalanceString();
	  tomovBalance = accountTomov.getBalanceString();

	  System.out.println(tomovBalance);
	  System.out.println(nessBalanace);
	  
	  
	  accountNestor.exchangeFromAccount(spouseCard_ness, // withraw
	  accountTomov,
	  spouseCard_tomov, // add
	  100);
	  
	  nessBalanace = accountNestor.getBalanceString();
	  tomovBalance = accountTomov.getBalanceString();
	  
	  System.out.println(tomovBalance);
	  System.out.println(nessBalanace);
	  
	  accountNestor.exchangeFromAccount(childCard_ness, // withraw
	  accountTomov,
	  childCard_Tomov, // add
	  50);
	  	  
	  nessBalanace = accountNestor.getBalanceString();
	  tomovBalance = accountTomov.getBalanceString();
	  
	  System.out.println(tomovBalance);
	  System.out.println(nessBalanace);
	  
	  accountNestor.payBill(personalCard_ness, 100);
	  nessBalanace = accountNestor.getBalanceString();
	  System.out.println(nessBalanace);
	}
}
