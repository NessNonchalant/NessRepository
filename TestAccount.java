import java.util.*;
import java.time.*;

class TestAccount {
    public static void main(String[] args) {
        Account accountNestor = new Account();
        accountNestor.setAccountNumber("BG80 BNBG 9661 1020 3456 78");
        accountNestor.setFullName("Nestor Svilenov Tsagov");
        accountNestor.setCurrency(Currency.BGN);

        Card cardNestor = new Card();
        cardNestor.setExpiryDate(LocalDate.parse("2026-06-13"));
        cardNestor.setProvider(Provider.MASTERCARD);
        cardNestor.setCardNumber("5500000000000004");

        accountNestor.addBalance(cardNestor, 100.05);
        accountNestor.payBill(80.05);

        System.out.println(accountNestor.getBalanceString());

        Account accountTomov = new Account();
        accountTomov.setAccountNumber("US64 SVBKU S6S3 3009 5887 6543");
        accountTomov.setFullName("Dimitar Dimitrov Tomov");
        accountTomov.setCurrency(Currency.USD);

        Card cardTomov = new Card();
        cardTomov.setExpiryDate(LocalDate.parse("2025-06-13"));
        cardTomov.setProvider(Provider.VISA);
        cardTomov.setCardNumber("5400000000000653");

        accountTomov.addBalance(cardTomov, 200.05);
        accountTomov.payBill(90.05);

        System.out.println(accountTomov.getBalanceString());

        accountTomov.exchangeFromAccount(accountNestor, 10.96);

        System.out.println(accountNestor.getBalanceString());
        System.out.println(accountTomov.getBalanceString());

        //Test NotEnoughFunds exception. Caller decides how to handle it.
        try {
            accountTomov.exchangeFromAccount(accountNestor, 20); // This should throw NotEnoughFundsException
        } catch (NotEnoughFundsException exception) {
            System.out.println("There is an exception:" + exception.getMessage());
        }

        Account accountToni = new Account();
        accountToni.setAccountNumber("BG46 BNBG 9683 1683 3902 12");
        accountToni.setFullName("Toni Paskalev Paskalev");
        accountToni.setCurrency(Currency.BGN);

        Card cardToni = new Card();
        cardToni.setExpiryDate(LocalDate.parse("2023-06-13"));
        cardToni.setProvider(Provider.VISA);
        cardToni.setCardNumber("5800000000000745");
        //Test CardNotValid exception. Caller decides how to handle it.
        try {
            accountToni.addBalance(cardToni, 300.05);
        } catch (CardNotValidException exception) {
            System.out.println("There is a an exception:" + exception.getMessage());
        }
    }
}