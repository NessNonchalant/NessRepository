package AccountCard.exceptions;

public class CardNotValidException extends RuntimeException {
    public CardNotValidException(String message) {
        super(message);
    }
}