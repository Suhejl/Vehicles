package ch.vehicles.tbz.vehicles;

public class Vehicle implements Comparable<Vehicle> {

    String name;
    String brand;
    String mainColor;
    String owner;
    String purchaseDate;

    @Override
    public int compareTo(Vehicle vehicles) {
        return 0;
    }
}
