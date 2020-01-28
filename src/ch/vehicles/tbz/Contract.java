package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Vehicle;
import java.util.Scanner;

/**
 * This class is an entity which represents a contract and contains all the needed data, to transact a car.
 */
public class Contract implements Definable {

    /**
     * The price of the transaction
     */
    private int amount;
    /**
     * From where the car is bought
     */
    private String from;
    /**
     * Who the new owner is
     */
    private String to;
    /**
     * Which car got transacted
     */
    private Vehicle vehicle;
    /**
     * An extra description if needed
     */
    private String description;
    /**
     * The date when the contract happened
     */
    private String date;


    /**
     * Form that gets executed when a new car is sold and removed from the stock
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     * @param vehicle that gets transacted
     */
    public void defineAttributesForSelling(Scanner inputValue, Vehicle vehicle) {
        this.vehicle = vehicle;

        System.out.println("Who will buy the car?");
        to = inputValue.nextLine();

        from = "Me";

        defineAttributes(inputValue);
    }

    /**
     * Form that gets executed when a new car is bought and added to the stock
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     * @param vehicle that gets transacted
     */
    public void defineAttributesForBuying(Scanner inputValue, Vehicle vehicle) {
        this.vehicle = vehicle;

        to = "Me";

        System.out.println("From where is the car bought?");
        from = inputValue.nextLine();

        defineAttributes(inputValue);
    }

    /**
     * Method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * This method isn't called from the service class. Its only called from the other two defineAttribute methods in this class, to decrease redundancy.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    @Override
    public void defineAttributes(Scanner inputValue){
        System.out.println("Further conditions of the contract?");
        description = inputValue.nextLine();

        while (true) {
            try {
                System.out.println("How expensive is the bought vehicle?");
                amount = Integer.parseInt(inputValue.nextLine());
                if (amount < 0 || amount > 1000000) continue;
            } catch (NumberFormatException nuex) {
                System.out.println("Please ");
                continue;
            }
            break;
        }
        System.out.println("On which date is this transaction made");
        date = inputValue.nextLine();
    }

    /**
     * Method that puts all the data from this class into a string and returns it.
     * @return String with all the data from this class
     */
    @Override
    public String toString(){
        return "Transaction at " + date + "\n-------------------------\n" + vehicle.toString() + " was sold\nFrom: " + from + "\nTo: " + to + "\nFor the price of: " + amount;
    }


    /**
     * Getters and Setters
     */
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Vehicle getCar() {
        return vehicle;
    }

    public void setCar(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
