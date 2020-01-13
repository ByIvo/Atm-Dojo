package atm;

public class InvalidAmountException extends RuntimeException {
    protected InvalidAmountException(int invalidAmount) {
        super("Invalid amount provided: " + invalidAmount);
    }
}
