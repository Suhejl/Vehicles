package ch.vehicles.tbz.vehicles;

public class MotorizedVehicle extends Vehicle {

    String licenceNumber;

    public MotorizedVehicle(String name, String brand, String mainColor, String purchaseDate, String enginePower, String lastInspection, String licenceNumber) {
        super(name, brand, mainColor, purchaseDate, enginePower, lastInspection);
        this.licenceNumber = licenceNumber;
    }

    public MotorizedVehicle(){
        super();
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
