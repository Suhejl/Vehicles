package ch.vehicles.tbz;
import java.util.Scanner;

/**
 * This is the Controller Class its needed to receive the users decision and lead him to the right method.
 */
public class VehicleController {

    Scanner inputValue = new Scanner(System.in);
    VehicleService vehicleService = new VehicleService();

    /**
     * This method shows all other methods to the user, that this application has to offer.
     * @return the number of the method the user wants to use
     */
    public String showMenu(){
        System.out.println("\n".repeat(20));
        System.out.println("Menu:\n" +
                "-----------------------------------\n" +
                "[1] to see all the vehicles on stock\n" +
                "[2] to see all of your sales\n" +
                "[3] to buy a new vehicle\n" +
                "[4] to sell a new vehicle\n" +
                "[5] to see your cash register");
        String entry = inputValue.nextLine();
        return entry;
    }

    /**
     * This method contains the switchcase that leads the user to his wanted method.
     * It has also error handling for wrong entries
     * @param entry id the decision of the user and the return value of showMenu()
     */
    public void switchCase(String entry){
        switch (entry){
            case "1":
                vehicleService.showStock();
                waitTillUserEntry();
                break;
            case "2":
                vehicleService.showTransactions();
                waitTillUserEntry();
                break;
            case "3":
                vehicleService.buyNewCarForm();
                waitTillUserEntry();
                break;
            case "4":
                vehicleService.sellVehicle();
                waitTillUserEntry();
                break;
            case "5":
                vehicleService.showCashRegister();
                waitTillUserEntry();
                break;
            case "X": case "x":
                System.out.println("System shutdown");
                break;
            default:
                System.out.println("Please enter a valid value");
                waitTillUserEntry();
        }
    }

    /**
     * This method stops the application until the user presses enter.
     * With that he's able to see the result of the previous method before the application continues.
     */
    public void waitTillUserEntry(){
        System.out.println("[Enter to continue]");
        inputValue.nextLine();
    }
}
