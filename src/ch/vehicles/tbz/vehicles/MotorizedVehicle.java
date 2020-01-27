package ch.vehicles.tbz.vehicles;

import java.util.Scanner;

/**
 * This class is an entity which represents a motorized vehicle and contains all the needed data, to define it.
 * All vehicles with a motor(everyone except the electrocar) extend from this class.
 */
public abstract class MotorizedVehicle extends Vehicle {

    /**
     * The number of the licenceplate every motorized vehicle has.
     */
   private String licenceNumber;


    /**
     * Constructor that fills the attributes.
     * They are automatically added.
     */
    public MotorizedVehicle(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection);
        this.licenceNumber = licenceNumber;
    }

    /**
     * Constructor that leaves the attributes empty.
     * They can manually be added later with the form.
     */
    public MotorizedVehicle(){}


    /**
     * Method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("Which licencenumber does the car have?");
        setLicenceNumber(inputValue.nextLine());
    }


    /**
     * Getters and Setters
     */
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
