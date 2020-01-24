package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Car;
import ch.vehicles.tbz.vehicles.ElectroCar;
import ch.vehicles.tbz.vehicles.Truck;
import ch.vehicles.tbz.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleService {

    FileEditor fileEditor = new FileEditor();
    ArrayList<Vehicle> vehicleList = new ArrayList<>();
    ArrayList<Contract> contractList = new ArrayList<>();
    int amount;
    Scanner inputValue = new Scanner(System.in);

    /**
     * Dummydata
     */
    public VehicleService(){
        amount = 10000;
        fileEditor.useFileData(vehicleList);
    }

    /**
     * The Form that gets executed when a new car should be bought.
     * It checks which type of vehicle Me wants.
     */
    public void buyNewVehicleForm(){
        System.out.println("Which carmodell do you want to create?");
        carOptions();
        String entry = inputValue.nextLine();
        try {
            buyNewVehicle(entry);
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid value");
        }
    }

    /**
     * Shows all options of cars that could be bought by me
     */
    public void carOptions(){
        System.out.println("[1] new electro car\n" +
                "[2] new car\n" +
                "[3] new truck");
    }

    /**ve
     * Creates a new vehicle and adds it to stock depending on entry.
     * @param entry is the type of vehicle that gets created.
     */
    public void buyNewVehicle(String entry){
        switch (entry){
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
        fileEditor.convertArrayToFile(vehicleList);
    }

    /**
     * Lets the user select a car that is beeing sold.
     */
    public void sellVehicle(){
        System.out.println("Which car should be sold?");
        showStock();
        Vehicle soldVehicle = vehicleList.get(Integer.parseInt(inputValue.nextLine()));

        makeContract(soldVehicle, true);
        vehicleList.remove(soldVehicle);
        System.out.println("Thank you for your purchase");
    }

    /**
     * Defines the variable of a new contract and adds it to the contractList.
     * @param vehicle that gets saved as attribute in the contract that was made
     * @param isSold
     */
    public void makeContract(Vehicle vehicle, boolean isSold){
        Contract contract = new Contract();

        if(isSold)
            contract.defineAttributesForSelling(inputValue, vehicle);
        else
            contract.defineAttributesForBuying(inputValue, vehicle);

        adjustCash(contract, isSold);
        contractList.add(contract);
        System.out.println("Contract has been successfully made");
    }

    /**
     * Adjusts the cashamount in amount.
     * @param contract amount gets adjusted by the cashamount in this object.
     * @param isSold decides if the cash gets added or removed
     */
    public void adjustCash(Contract contract, boolean isSold){
        if(isSold)
            amount += contract.getAmount();
        else
            amount -= contract.getAmount();
    }

    /**
     * Method that show all the cash Me has available
     */
    public void showCashRegister(){
        System.out.println("You have " + amount + " CHF in your cashregister");
    }

    /**
     * Method that shows all purchases and sales from the past
     */
    public void showTransactions(){
        if(contractList.isEmpty())
            System.out.println("You have not had transactions yet");
        else{
            for(Contract contract : contractList){
                System.out.println(contract.toString() + "\n");
            }
        }
    }

    /**
     * Method that prints out all the cars that are available and could be sold to customers.
     */
    public void showStock(){
        if(vehicleList.isEmpty())
            System.out.println("You have no vehicles on stock");
        else{
            for(int x = 1; x <= vehicleList.size();x++){
                System.out.println("[" + x + "] " + vehicleList.get(x-1).toString());
            }
        }
    }
}
