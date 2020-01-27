package ch.vehicles.tbz;

public class NoVehiclesOnStockException extends Exception {
  public NoVehiclesOnStockException() {
    super("You have no vehicles on stock");
  }

  public NoVehiclesOnStockException(String message) {
    super(message);
  }
}
