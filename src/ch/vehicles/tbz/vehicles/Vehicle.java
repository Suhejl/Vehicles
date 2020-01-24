package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

/**
 * This class is an entity which represents a vehicle and contains all the needed data, to define it.
 * Every other vehicle class extends from this one.
 * Its the root class.
 */
public abstract class Vehicle implements Definable {

    /**
     * The name of the modell of this vehicle
     */
    private String name;
    /**
     * The brand to which this vehicle belongs
     */
    private String brand;
    /**
     * The color of this vehicle
     */
    private String mainColor;
    /**
     * The date when this vehicle was bought
     */
    private String purchaseDate;
    /**
     * The power of the engine this vehicle has
     */
    private String enginePower;
    /**
     * The date when this vehicle was inspected the last time
     */
    private String lastInspection;


    /**
     * Constructor that fills the attributes.
     * They are automatically added.
     */
    public Vehicle(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection) {
        this.name = name;
        this.brand = brand;
        this.mainColor = mainColor;
        this.purchaseDate = purchaseDate;
        this.enginePower = enginePower;
        this.lastInspection = lastInspection;
    }

    /**
     * Constructor that leaves the attributes empty.
     * They can manually be added later with the form.
     */
    public Vehicle(){}

    /**
     * Method that defines all attributes of the vehicle and shows a success message
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     * @returns the own entity should be returned.
     */
    abstract public Vehicle buy(Scanner inputValue);

    /**
     * method that is inherited from Definable and represents a form with which the user can define the attributes of this class.
     * @param inputValue is a Scanner object, that allows the user to scan userentries from the console.
     */
    @Override
    public void defineAttributes(Scanner inputValue) {
        System.out.println("What's toadys date?");
        setPurchaseDate(inputValue.nextLine());

        System.out.println("Which brand has this car?");
        setBrand(inputValue.nextLine());

        System.out.println("What's the name of the modell?");
        setName(inputValue.nextLine());

        System.out.println("How is the car colored?");
        setMainColor(inputValue.nextLine());

        System.out.println("How much HP does the car have?");
        setEnginePower(inputValue.nextLine());

        System.out.println("On which day was the last inspection?");
        setLastInspection(inputValue.nextLine());
    }

    /**
     * Method that puts all the data from this class into a string and returns it.
     * @return String with all the data from this class
     */
    @Override
    public String toString(){
        return getBrand() + " - " + getName() + " in " +  getMainColor();
    }


    /**
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(String lastInspection) {
        this.lastInspection = lastInspection;
    }
}
