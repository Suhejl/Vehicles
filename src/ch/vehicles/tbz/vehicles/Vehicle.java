package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle>, Definable {

    private String name;
    private String brand;
    private String mainColor;
    private String purchaseDate;
    private String enginePower;
    private String lastInspection;

    public Vehicle(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection) {
        this.name = name;
        this.brand = brand;
        this.mainColor = mainColor;
        this.purchaseDate = purchaseDate;
        this.enginePower = enginePower;
        this.lastInspection = lastInspection;
    }

    public Vehicle(){}

    @Override
    public int compareTo(Vehicle vehicles) {
        return 0;
    }

    @Override
    public String toString(){
        return getBrand() + " - " + getName() + " in " +  getMainColor();
    }

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
}
