package ch.vehicles.tbz.model;

import ch.vehicles.tbz.view.Main;

import java.util.Scanner;

public class Vehicles implements Comparable<Vehicles>{

  String name;
  String brand;
  String color;
  String owner;
  String date;


  public String getName() {
    return name;
  }

  public String getBrand() {
    return brand;
  }

  public String getOwner() {
    return owner;
  }

  public String getDate() {
    return date;
  }

  public Vehicles() {
  }

 
  
  
  public void getInformation(Scanner scan) {
    System.out.print("Name: ");
    name = scan.next();
    System.out.println();

    System.out.print("Marke: ");
    brand = scan.next();
    System.out.println();

    System.out.print("Farbe: ");
    color = scan.next();
    System.out.println();

    System.out.print("Besitzer: ");
    owner = scan.next();
    System.out.println();

    System.out.print("Erwerbsdatum: ");
    date = scan.next();
    System.out.println();

  }




  @Override
  public String toString() {
    return "Vehicles [name=" + name + ", brand=" + brand + ", color=" + color + ", owner=" + owner + ", date=" + date
        + "]";
  }




  @Override
  public int compareTo(Vehicles o) {
    // TODO Auto-generated method stub
    switch(Main.sort) {
      case 1:
        return o.owner.compareTo(owner);
      case 2:
        return o.date.compareTo(date);
      case 3:
        return o.brand.compareTo(brand);
      case 4:
        return o.name.compareTo(name);
    }
    return 0;
  }

}
