package ch.vehicles.tbz.model;

import java.util.Scanner;

public class KickBoards extends Boards {
  String height;

  public KickBoards() {

  }

  public void getInformation(Scanner scan) {
    super.getInformation(scan);
    System.out.print("Hoehe: ");
    height = scan.next();
    System.out.println();
  }

  @Override
  public String toString() {
    return "[Name;Marke;Farbe;Besitzer;Erwerbsdatum;Laenge;Haehe]\n\n" + String.join(";", name, brand, color, owner, date, length, height);
  }

}
