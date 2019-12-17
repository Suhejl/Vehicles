package ch.vehicles.tbz.model;

import java.util.Scanner;

public class VehicleWheels extends NoneMotorizedWheel{
 
  String licenceNumber;
  String enginePower;
  public VehicleWheels() {
  }
  
  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Kennzeichen: ");
    licenceNumber = scan.next();
    System.out.println();

    System.out.print("Motorleistung: ");
    enginePower = scan.next();
    System.out.println();
  }
  
  
}
