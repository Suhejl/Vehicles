package ch.vehicles.tbz;

import java.sql.Connection;
import java.util.Scanner;


public class VehicleController {

    Scanner inputValue = new Scanner(System.in);
    VehicleService vehicleService = new VehicleService();

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

    public void switchCase(String entry){
        switch (entry){
            case "1":
                vehicleService.showStock();
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
                break;
            case "2":
                vehicleService.showTransactions();
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
                break;
            case "3":
                vehicleService.buyNewCarForm();
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
                break;
            case "4":
                vehicleService.sellVehicle();
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
                break;
            case "5":
                vehicleService.showCashRegister();
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
                break;
            case "X": case "x":
                System.out.println("System shutdown");
                break;
            default:
                System.out.println("Please enter a valid value");
                System.out.println("[Enter to continue]");
                inputValue.nextLine();
        }
    }
}
