package ch.vehicles.tbz;

/**
 * This is an Exception, which gets thrown, when there's no vehicle on stock
 **/
public class NoVehiclesOnStockException extends Exception {

  /**
   * Basic constructor with basic message sent to superclass constructor
   */
  public NoVehiclesOnStockException() {
    super("You have no vehicles on stock");
  }

  /**
   * Constructor that calls the superclass constructor with the given message
   * @param message is a message, which gets set as the message field of this Exception
   */
  public NoVehiclesOnStockException(String message) {
    super(message);
  }
}
