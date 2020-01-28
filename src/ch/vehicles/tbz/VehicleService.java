package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Car;
import ch.vehicles.tbz.vehicles.ElectroCar;
import ch.vehicles.tbz.vehicles.Truck;
import ch.vehicles.tbz.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the whole logic pf the program on creating, deleting and overwriting all things.
 */
public class VehicleService {

  /**
   * amount is a varibale containing the cash amount of the salesman
   */
  int amount;
  /**
   * Source is a String that contains the path to the file representing the database
   */
  String source;
  FileEditor fileEditor = new FileEditor();
  ArrayList<Vehicle> vehicleList = new ArrayList<>();
  ArrayList<Contract> contractList = new ArrayList<>();
  Scanner inputValue = new Scanner(System.in);

  /**
   * Dummydata
   */
  public VehicleService(String source) {
    amount = 10000;
    this.source = source;
    fileEditor.useFileData(vehicleList, source);
  }

  /**
   * The Form that gets executed when a new car should be bought.
   * It checks which type of vehicle Me wants.
   */
  public void buyNewVehicleForm() {
    System.out.println("Which carmodell do you want to create?");
    carOptions();
    String entry = inputValue.nextLine();
    try {
      buyNewVehicle(entry);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid value");
    }
  }

  /**
   * Shows all options of cars that could be bought by me
   */
  public void carOptions() {
    System.out.println("[1] new electro car\n" +
        "[2] new car\n" +
        "[3] new truck");
  }

  /**
   * ve
   * Creates a new vehicle and adds it to stock depending on entry.
   *
   * @param entry is the type of vehicle that gets created.
   */
  public void buyNewVehicle(String entry) {
    switch (entry) {
      case "1":
        ElectroCar electroCar = new ElectroCar();
        vehicleList.add(electroCar.buy(inputValue));
        makeContract(electroCar, false);
        break;
      case "2":
        Car car = new Car();
        vehicleList.add(car.buy(inputValue));
        makeContract(car, false);
        break;
      case "3":
        Truck truck = new Truck();
        vehicleList.add(truck.buy(inputValue));
        makeContract(truck, false);
        break;
      default:
        System.out.println("Please enter a number between 1 - 3");
    }
    fileEditor.convertArrayToFile(vehicleList, source);
  }

  /**
   * Lets the user select a car that is beeing sold.
   */
  public void sellVehicle() {
    try {
      System.out.println("Which car should be sold?");
      showStock();
      Vehicle soldVehicle = vehicleList.get(Integer.parseInt(inputValue.nextLine()) - 1);

      makeContract(soldVehicle, true);
      vehicleList.remove(soldVehicle);
      System.out.println("Thank you for your purchase");
    } catch (NumberFormatException | IndexOutOfBoundsException e) {
      System.out.println("Please enter a valid value");
    }
  }

  /**
   * Defines the variable of a new contract and adds it to the contractList.
   *
   * @param vehicle that gets saved as attribute in the contract that was made
   * @param isSold
   */
  public void makeContract(Vehicle vehicle, boolean isSold) {
    Contract contract = new Contract();

    if (isSold)
      contract.defineAttributesForSelling(inputValue, vehicle);
    else
      contract.defineAttributesForBuying(inputValue, vehicle);

    adjustCash(contract, isSold);
    contractList.add(contract);
    System.out.println("Contract has been successfully made");
  }

  /**
   * Testable
   * <p>
   * Adjusts the cashamount in amount.
   *
   * @param contract amount gets adjusted by the cashamount in this object.
   * @param isSold   decides if the cash gets added or removed
   */
  public void adjustCash(Contract contract, boolean isSold) {
    if (isSold)
      amount += contract.getAmount();
    else
      amount -= contract.getAmount();
  }

  /**
   * Method that show all the cash Me has available
   */
  public void showCashRegister() {
    System.out.println("You have " + amount + " CHF in your cashregister");
  }

  /**
   * Method that shows all purchases and sales from the past
   */
  public void showTransactions() {
    try {
      if (contractList.isEmpty()) throw new NoTransactionException();

      for (Contract contract : contractList) {
        System.out.println(contract.toString() + "\n");
      }

    } catch (NoTransactionException noex) {
      System.out.println(noex.getMessage());
    }
  }


  /**
   * Method that prints out all the cars that are available and could be sold to customers.
   */
  public void showStock() {
    try {
      if (vehicleList.isEmpty()) throw new NoVehiclesOnStockException();

      for (int x = 1; x <= vehicleList.size(); x++) {
        System.out.println("[" + x + "] " + vehicleList.get(x - 1).toString());
      }
    } catch (NoVehiclesOnStockException noex) {
      System.out.println(noex.getMessage());
    }

  }

  /**
   * Getters and Setters
   */
  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }
}
