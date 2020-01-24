package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

/**
 * This class is an entity which represents a car and contains all the needed data, to define it.
 */
public class Car extends MotorizedVehicle implements Definable {

    /**
     * The amount of doors the car has
     */
    private int doors;


    /**
     * Constructor that fills the attributes.
     * They are automatically added.
     */
    public Car(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber, int doors) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection, licenceNumber);
        this.doors = doors;
    }

    /**
     * Constructor that leaves the attributes empty.
     * They can manually be added later with the form.
     */
    public Car(){}


    /**
     * Method that defines all attributes of the car and shows a success message
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     * @returns the own entity should be returned.
     */
    @Override
    public Car buy(Scanner inputValue) {
        defineAttributes(inputValue);
        System.out.println("Truck has been successfully created");
        return this;
    }

    /**
     * @return a String that can be printed in the csv file and understood by the csv reader
     */
    @Override
    public String getCsvString() {
        return "Car;" + getName() + ";" + getBrand() + ";" + getMainColor() + ";" + getPurchaseDate() + ";" + getEnginePower() + ";" + getLastInspection() + ";" + getLicenceNumber() + ";" + getDoors() + "\n";
    }

    /**
     * Method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How many doors has your car?");
        setDoors(Integer.parseInt(inputValue.nextLine()));
    }


    /**
     * Getters and Setters
     */
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
