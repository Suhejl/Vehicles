package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Vehicle;

import java.util.Scanner;

public class Contract {

    private int amount;
    private String from;
    private String to;
    private Vehicle vehicle;
    private String description;
    private String date;

    public void defineAttributesForSelling(Scanner inputValue, Vehicle vehicle) {
        this.vehicle = vehicle;

        System.out.println("Who will buy the car?");
        to = inputValue.nextLine();

        from = "Me";

        System.out.println("Further conditions of the contract?");
        description = inputValue.nextLine();

        System.out.println("How expensive is the bought vehicle?");
        amount = Integer.parseInt(inputValue.nextLine());

        System.out.println("On which date is this transaction made");
        date = inputValue.nextLine();
    }

    public void defineAttributesForBuying(Scanner inputValue, Vehicle vehicle) {
        this.vehicle = vehicle;

        to = "Me";

        from = "Company";

        System.out.println("Further conditions of the contract?");
        description = inputValue.nextLine();

        System.out.println("How expensive is the bought vehicle?");
        amount = Integer.parseInt(inputValue.nextLine());

        System.out.println("On which date is this transaction made");
        date = inputValue.nextLine();
    }

    @Override
    public String toString(){
        return "Transaction at " + date + "\n-------------------------\n" + vehicle.toString() + " was sold\nFrom: " + from + "\nTo: " + to + "\nFor the price of: " + amount;
    }


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
