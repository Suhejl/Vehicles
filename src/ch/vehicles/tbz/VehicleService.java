package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Car;
import ch.vehicles.tbz.vehicles.ElectroCar;
import ch.vehicles.tbz.vehicles.Truck;
import ch.vehicles.tbz.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleService {

    ArrayList<Vehicle> vehicleList = new ArrayList<>();
    ArrayList<Contract> contractList = new ArrayList<>();
    int amount;
    Scanner inputValue = new Scanner(System.in);

    /**
     * Dummydata
     */
    public VehicleService(){
        amount = 10000;
        Car car1 = new Car("8er coupé", "BMW", "black", "24.01.2020", "200 HP", "24.01.2020", "69420", 4);
        Car car2 = new Car("Grand Tourismo", "BMW", "red", "24.01.2020", "170 HP", "24.01.2020", "12345", 4);
        Car car3 = new Car("4er Cabrio", "BMW", "blue", "24.01.2020", "150 HP", "24.01.2020", "00000", 4);
        ElectroCar electroCar1 = new ElectroCar("Modell 3", "Tesla", "blue", "24.01.2020", "200 HP", "24.01.2020", "10 hours");
        ElectroCar electroCar2 = new ElectroCar("Modell S", "Tesla", "white", "24.01.2020", "220 HP", "24.01.2020", "15 hours");
        ElectroCar electroCar3 = new ElectroCar("Modell X", "Tesla", "white", "24.01.2020", "250 HP", "24.01.2020", "24 hours");
        Truck truck1 = new Truck("normal Truck", "Mercedes", "white", "24.01.2020", "150 HP", "24.01.2020", "54321", "1000 Kg");
        Truck truck2 = new Truck("mega Truck", "Mercedes", "white", "24.01.2020", "150 HP", "24.01.2020", "5318008", "2000 Kg");
        Truck truck3 = new Truck("ultra Truck", "Mercedes", "black with flames on the side", "24.01.2020", "150 HP", "24.01.2020", "I dont even know anymore", "5000 Kg");
        vehicleList.add(car1);
        vehicleList.add(car2);
        vehicleList.add(car3);
        vehicleList.add(electroCar1);
        vehicleList.add(electroCar2);
        vehicleList.add(electroCar3);
        vehicleList.add(truck1);
        vehicleList.add(truck2);
        vehicleList.add(truck3);
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
        System.out.println("[1] tesla\n" +
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
