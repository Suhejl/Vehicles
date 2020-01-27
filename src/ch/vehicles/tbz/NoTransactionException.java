package ch.vehicles.tbz;

public class NoTransactionException extends Exception {
  public NoTransactionException() {
    super("You have not had transactions yet");
  }

  public NoTransactionException(String message) {
    super(message);
  }
}
