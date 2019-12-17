package ch.vehicles.tbz.model;

import java.util.Scanner;

public class Inspections extends VehicleWheels{  
   String inspections;

  public Inspections() {}
  
  
  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Zuletzt vorgefuehrt am: ");
    inspections = scan.next();
    System.out.println();

  }
}
