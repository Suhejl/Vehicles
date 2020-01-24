package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

public class Car extends MotorizedVehicle implements Definable {

    private int doors;

    public Car(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber, int doors) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection, licenceNumber);
        this.doors = doors;
    }

    public Car(){}

    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How many doors has your car?");
        setDoors(Integer.parseInt(inputValue.nextLine()));
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
