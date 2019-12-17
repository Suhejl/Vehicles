package ch.vehicles.tbz.model;

import java.util.Scanner;

public class Cars extends Inspections{

  String doors;

  public Cars() {
  } 
  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Anzahl Tueren: ");
    doors = scan.next();
    System.out.println();


  }
  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Anzahl_Tueren;Fahrgestellnummer;Kennzeichen;Motorleistung;Zuletzt_vorgefuehrt_am]\n\n" + String.join(";", name, brand, color, owner, date, doors, chassisnumber, licenceNumber, enginePower, inspections);
  }
  
  
}
