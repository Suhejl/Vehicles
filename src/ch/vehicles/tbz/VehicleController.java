package ch.vehicles.tbz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class VehicleController {

    Scanner inputValue = new Scanner(System.in);
    VehicleService vehicleService;

    Connection connection;

    public VehicleController(Connection connection) {
        this.connection = connection;
        vehicleService = new VehicleService(connection);
    }

    public String showMenu(){
        System.out.println("Menu:\n" +
                "-----------------------------------\n" +
                "[1] to the vehicles on stock\n" +
                "[2] to see all of your sales\n" +
                "[3] to buy a new vehicle\n" +
                "[4] to sell a new vehicle\n" +
                "[5] to see your cash register");
        String entry = inputValue.nextLine();
        return entry;
    }

    public void switchCase(String entry) throws SQLException {
        switch (entry){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                vehicleService.showCashRegister();
                break;
            case "X": case "x":
                System.out.println("System shutdown");
                break;
            default:
                System.out.println("Please enter a valid value");
        }
    }
}
