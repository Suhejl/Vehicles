package ch.vehicles.tbz;

import ch.vehicles.tbz.vehicles.Car;
import ch.vehicles.tbz.vehicles.ElectroCar;
import ch.vehicles.tbz.vehicles.Truck;
import ch.vehicles.tbz.vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles the Input and Output stream with files.
 * Since a csv file is used as database, this class is able to rewrite, delete and add data from there.
 */
public class FileEditor {

    /**
     * This method saves all the data from the csv file in the arrayList and serves as a small database.
     * @param vehicleList is the ArrayList in which the data gets saved
     */
    public void useFileData(ArrayList<Vehicle> vehicleList, String source){
        File dummyFile = new File(source);
        Scanner dummyScanner;
        try{
            dummyScanner = new Scanner(dummyFile);
            while(dummyScanner.hasNextLine()){
                String[] fields = dummyScanner.nextLine().split(";");
                if(fields[0].equals("Car")){
                    vehicleList.add(new Car(fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], Integer.parseInt(fields[8])));
                }else if(fields[0].equals("ElectroCar")){
                    vehicleList.add(new ElectroCar(fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7]));
                }else if(fields[0].equals("Truck")){
                    vehicleList.add(new Truck(fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8]));
                }
            }
            dummyScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copies the given arraylist into the dummyFile to overwrite it.
     * @param allVehicles ArrayList.
     * @return true if the creation was successful, false if not.
     */
    public boolean convertArrayToFile(ArrayList<Vehicle> allVehicles, String source){
        File oldData = new File(source);
        if(deleteOldFile(oldData)){
            if(createNewFile(oldData)){
                return writeInFile(allVehicles, oldData);
            }
        }
        return false;
    }

    public boolean writeInFile(ArrayList<Vehicle> allVehicles, File oldData){
        try {
            BufferedWriter copyToWriter = new BufferedWriter(new FileWriter(oldData));
            for(int x = 0; x <allVehicles.size(); x++){
                copyToWriter.append(allVehicles.get(x).getCsvString());
            }
            copyToWriter.close();
            return true;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tries to create the file given as parameter.
     * @param file .
     * @return true if it could be created.
     */
    public boolean createNewFile(File file){
        try{
            if(file.createNewFile())
                return true;
            System.out.println("The File already exists");
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tries to delete the file given as parameter.
     * @param file .
     * @return true if it could be deleted.
     */
    public boolean deleteOldFile(File file){
        if(file.delete())
            return true;
        System.out.println("File could not be deleted");
        return false;
    }
}
