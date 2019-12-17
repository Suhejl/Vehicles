package ch.vehicles.tbz.view;

import ch.vehicles.tbz.model.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static int sort;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LinkedList<Vehicles> vehicleList = new LinkedList<>();
    System.out.println();
    Scanner scan = new Scanner(System.in);
    String answer;
    boolean yn = true;
    do {
      System.out.print(
          "Was wollen Sie machen?\nDruecken Sie die:\n1 zum erschaffen eines Autos\n2 zum erschaffen eines LKWs\n3 zum erschaffen eines motorisiertes Zweirad\n4 zum erschaffen eines nicht-motorisiertes Zweirad\n5 zum erschaffen eines Kick-Boards\n6 zum erschaffen eines Long-Boards\n\n>");
      int choice = scan.nextInt();
      
      switch (choice) {
        case 1:
          Cars car = new Cars();
          car.getInformation(scan);
          vehicleList.add(car);
          break;
        case 2:
          Trucks truck = new Trucks();
          truck.getInformation(scan);
          vehicleList.add(truck);
          break;
        case 3:
          Motorized2Wheel wheel = new Motorized2Wheel();
          wheel.getInformation(scan);

          vehicleList.add(wheel);
          break;
        case 4:
          NoneMotorizedWheel no_wheel = new NoneMotorizedWheel();
          no_wheel.getInformation(scan);
          vehicleList.add(no_wheel);
          break;
        case 5:
          KickBoards kickBoard = new KickBoards();
          kickBoard.getInformation(scan);
          vehicleList.add(kickBoard);
          break;
        case 6:
          LongBoards longBoard = new LongBoards();
          longBoard.getInformation(scan);
          vehicleList.add(longBoard);
          break;
      }

      do {
        System.out.print("\n\nWollen Sie fortfahren? (y/n) \n> ");
        answer = scan.next();
      } while (answer(answer));
      yn = "y".equalsIgnoreCase(answer);
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      if (!(yn)) {
        System.out.println("Hier sind deine Eintraege:");
      }
    } while (yn);
    System.out.println();
    sortList(vehicleList);
  }

  static void sortList(LinkedList<Vehicles> vehicleList) {
    Scanner scan = new Scanner(System.in);

    do {
      System.out.print(
          "Willst du die Liste nach [1] Besitzer, nach [2] Erwerbsdartum, nach [3] Marke oder nach [4] Name sortieren\n>");
      sort = scan.nextInt();
      if (0 >= sort || sort > 5) {
        System.out.println("Bitte eine gueltige Nummer eintrtagen.");
      }

    } while (0 >= sort || sort > 5);

    Collections.sort(vehicleList, new Comparator<Vehicles>() {
      @Override
      public int compare(Vehicles o1, Vehicles o2) {
        // TODO Auto-generated method stub

        switch (sort) {
          case 1:
            return o1.getOwner().compareTo(o2.getOwner());
          case 2:
            return o1.getDate().compareTo(o2.getDate());
          case 3:
            return o1.getBrand().compareTo(o2.getBrand());
          case 4:
            return o1.getName().compareTo(o2.getName());
          default:
            return 0;

        }
      }

    });


    for (Vehicles eachVehicle : vehicleList) {
      System.out.println();
      System.out.println();
      System.out.println(eachVehicle);
    }
  }

  public static boolean answer(String yn) {
    return !"y".equalsIgnoreCase(yn) && !"n".equalsIgnoreCase(yn);
  }
}
