package ch.vehicles.tbz.model;

import java.util.Scanner;

public class Boards extends Vehicles{
  String length;
   public Boards() {}
   
   
   public void getInformation(Scanner scan) {
     super.getInformation(scan);
     System.out.print("Laenge: ");
     length = scan.next();
     System.out.println();
   }
}
