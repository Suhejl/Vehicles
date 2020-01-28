import ch.vehicles.tbz.FileEditor;
import ch.vehicles.tbz.vehicles.Car;
import ch.vehicles.tbz.vehicles.ElectroCar;
import ch.vehicles.tbz.vehicles.Truck;
import ch.vehicles.tbz.vehicles.Vehicle;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

/**
 * This testing class tests the FileEditor class and assures that the input and output stream into the file works
 */
public class FileEditorTest {

    FileEditor fileEditor = new FileEditor();

    /**
     * This class reads the data from the DummyData file, that was inserted in the lower test
     * If the data matches with the lower data it is accepted
     */
    @Test
    public void useFileData_givesArrayList_returnsFilledArrayList(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        fileEditor.useFileData(vehicleList, "testing\\DummyData.csv");

        assertEquals( 6, vehicleList.size());
        assertEquals("brumm brumm", vehicleList.get(0).getName());
        assertEquals( "zoom", vehicleList.get(1).getName());
        assertEquals("i am speed", vehicleList.get(2).getName());
        assertEquals("Kachba", vehicleList.get(3).getName());
        assertEquals("normal Truck", vehicleList.get(4).getName());
        assertEquals("cabrio Truck", vehicleList.get(5).getName());
    }

    /**
     * This test deletes the old file and puts some new data in it
     * It is accepted if deleteOldFile, createNewFile and writeInFile returns true
     */
    @Test
    public void convertArrayToFile_givesArray_createsNewFileWithArrayData(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car("brumm brumm", "auto", "black", "24.01.2020", "200 HP", "24.01.2020", "69420", 4));
        vehicleList.add(new Car("zoom", "BMW", "red", "24.01.2020", "170 HP", "24.01.2020", "12345", 4));
        vehicleList.add(new ElectroCar("i am speed", "solarcar", "blue", "24.01.2020", "200 HP", "24.01.2020", "while true loop"));
        vehicleList.add(new ElectroCar("Kachba", "Tesla", "white", "24.01.2020", "220 HP", "24.01.2020", "15 hours"));
        vehicleList.add(new Truck("normal Truck", "Mercedes", "white", "24.01.2020", "150 HP", "24.01.2020", "54321", "1000 Kg"));
        vehicleList.add(new Truck("cabrio Truck", "Hr. Kaeser", "white", "24.01.2020", "150 HP", "24.01.2020", "5318008", "2000 Kg"));

        assertTrue(fileEditor.deleteOldFile(new File("testing\\DummyData.csv")));
        assertTrue(fileEditor.createNewFile(new File("testing\\DummyData.csv")));
        assertTrue(fileEditor.writeInFile(vehicleList, new File("testing\\DummyData.csv")));
    }

}
