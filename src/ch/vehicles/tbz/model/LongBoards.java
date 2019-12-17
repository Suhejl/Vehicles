package ch.vehicles.tbz.model;

import java.util.Scanner;

public class LongBoards extends Boards {
  String scootera_and_WarehouseType;

  public LongBoards() {
  }

  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Rollen- und Lagertyp: ");
    scootera_and_WarehouseType = scan.next();
    System.out.println();
  }

  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Laenge;RollenUndLagerTyp]\n\n"
        + String.join(";", name, brand, color, owner, date, length, scootera_and_WarehouseType);
  }

}
