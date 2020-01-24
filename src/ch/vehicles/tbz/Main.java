package ch.vehicles.tbz;

/**
 * This is the main class containing the whole application.
 * It is repeated until the user decides to press x and exit the application.
 */
public class Main {

  public static void main(String[] args){
    /**
     * Contains the Userentry and is used to decide which method should be executed
     */
    String entry = "";

    VehicleController vehicleController = new VehicleController();

      do{
        entry = vehicleController.showMenu();
        vehicleController.switchCase(entry);
      }while(!"x".equals(entry.toLowerCase()));

  }
}
