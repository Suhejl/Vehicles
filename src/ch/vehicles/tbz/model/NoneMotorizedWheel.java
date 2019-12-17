package ch.vehicles.tbz.model;

import java.util.Scanner;

public class NoneMotorizedWheel extends Vehicles{

  String chassisnumber;
  public NoneMotorizedWheel() {
    }
  
  
  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Fahrgestellnummer: ");
    chassisnumber = scan.next();
    System.out.println();

   }


  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Fahrgestellnummer]\n\n" + String.join(";", name, brand, color, owner, date, chassisnumber);
  }
  
  
  }
