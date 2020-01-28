package ch.vehicles.tbz;

/**
 * This is an Exception, which gets thrown, when there's no transaction made
 **/
public class NoTransactionException extends Exception {

  /**
   * Basic constructor with basic message sent to superclass constructor
   */
  public NoTransactionException() {
    super("You have not had transactions yet");
  }

  /**
   * Constructor that calls the superclass constructor with the given message
   * @param message is a message, which gets set as the message field of this Exception
   */
  public NoTransactionException(String message) {
    super(message);
  }
}
