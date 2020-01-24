package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

/**
 * This class is an entity which represents an electrocar and contains all the needed data, to define it.
 */
public class ElectroCar extends Vehicle implements Definable {

    /**
     * The duration of the battery of this electrocar
     */
    private String batteryDuration;


    /**
     * Constructor that fills the attributes.
     * They are automatically added.
     */
    public ElectroCar(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String batteryDuration) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection);
        this.batteryDuration = batteryDuration;
    }

    /**
     * Constructor that leaves the attributes empty.
     * They can manually be added later with the form.
     */
    public ElectroCar(){}


    /**
     * Method that defines all attributes of the electrocar and shows a success message
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     * @returns the own entity should be returned.
     */
    @Override
    public ElectroCar buy(Scanner inputValue) {
        defineAttributes(inputValue);
        System.out.println("Truck has been successfully created");
        return this;
    }

    /**
     * Method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How long does the battery of the modell last?");
        setBatteryDuration(inputValue.nextLine());
    }


    /**
     * Getters and Setters
     */
    public String getBatteryDuration() {
        return batteryDuration;
    }

    public void setBatteryDuration(String batteryDuration) {
        this.batteryDuration = batteryDuration;
    }
}
