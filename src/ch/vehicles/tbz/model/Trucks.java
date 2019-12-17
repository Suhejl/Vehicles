package ch.vehicles.tbz.model;

import java.util.Scanner;

public class Trucks extends Inspections {
  String payload;
  boolean doubleCabine;

  public Trucks() {
  }

  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Zuladung in Kg: ");
    payload = scan.next();
    System.out.println();
    System.out.print("Doppelkabine(True/False): ");
    doubleCabine = scan.nextBoolean();
    System.out.println();

  }

  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Zuladung_in_Kg;Fahrgestellnummer;Kennzeichen;Motorleistung;Zuletzt_vorgefuehrt_am;Doppelkabine(True/False)]\n\n"
        + String.join(";", name, brand, color, owner, date, payload, chassisnumber, licenceNumber, enginePower,
            inspections, "" + doubleCabine);
  }

}
