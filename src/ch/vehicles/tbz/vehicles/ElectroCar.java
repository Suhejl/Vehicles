package ch.vehicles.tbz.vehicles;

import ch.vehicles.tbz.Definable;

import java.util.Scanner;

public class ElectroCar extends Vehicle implements Definable {


    private String batteryDuration;

    public ElectroCar(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String batteryDuration) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection);
        this.batteryDuration = batteryDuration;
    }

    public ElectroCar(){}

    @Override
    public void defineAttributes(Scanner inputValue){
        super.defineAttributes(inputValue);
        System.out.println("How long does the battery of the modell last?");
        setBatteryDuration(inputValue.nextLine());
    }

    public String getBatteryDuration() {
        return batteryDuration;
    }

    public void setBatteryDuration(String batteryDuration) {
        this.batteryDuration = batteryDuration;
    }
}
