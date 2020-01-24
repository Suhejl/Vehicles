package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

/**
 * This class is an entity which represents a truck and contains all the needed data, to define it.
 */
public class Truck extends MotorizedVehicle implements Definable {

    /**
     * The amount of payLoad the truck is able to carry
     */
    private String payLoad;


    /**
     * Constructor that fills the attributes.
     * They are automatically added.
     */
    public Truck(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber, String payLoad) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection, licenceNumber);
        this.payLoad = payLoad;
    }

    /**
     * Constructor that leaves the attributes empty.
     * They can manually be added later with the form.
     */
    public Truck(){}


    /**
     * Method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How much payload can your truck carry?");
        setPayLoad(inputValue.nextLine());
    }


    /**
     * Getters and Setters
     */
    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
