package ch.vehicles.tbz.model;

import java.util.Scanner;

public class Motorized2Wheel extends VehicleWheels {
  boolean electroEngine;

  public Motorized2Wheel() {
  }

  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Elektroantrieb(True/False): ");
    electroEngine = scan.nextBoolean();
    System.out.println();
  }

  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Elektroantrieb(True/False);Fahrgestellnummer;Kennzeichen;Motorleistung]\n\n"
        + String.join(";", name, brand, color, owner, date, "" + electroEngine, chassisnumber, licenceNumber,
            enginePower);
  }

}
