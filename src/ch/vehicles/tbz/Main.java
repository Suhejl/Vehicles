package ch.vehicles.tbz;

import java.sql.Connection;

public class Main {

  public static void main(String[] args){

    String entry = "";

    VehicleController vehicleController = new VehicleController();

      do{
        entry = vehicleController.showMenu();
        vehicleController.switchCase(entry);
      }while(!"x".equals(entry.toLowerCase()));

  }
}
