package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

public class Truck extends MotorizedVehicle implements Definable {

    private String payLoad;

    public Truck(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber, String payLoad) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection, licenceNumber);
        this.payLoad = payLoad;
    }


    public Truck(){}

    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How much payload can your truck carry?");
        setPayLoad(inputValue.nextLine());
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
