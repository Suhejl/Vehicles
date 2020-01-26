import ch.vehicles.tbz.Contract;
import ch.vehicles.tbz.VehicleService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleServiceTest {

    VehicleService vehicleService = new VehicleService("testing\\DummyData.csv");

    @Test
    public void adjustCash_requestAddition_receiveAddition(){
        boolean isSold = true;

        Contract contract = new Contract();
        contract.setAmount(2000);

        vehicleService.adjustCash(contract, isSold);
        assertEquals(vehicleService.getAmount(), 12000);

        isSold = false;
        vehicleService.adjustCash(contract, isSold);
        assertEquals(vehicleService.getAmount(), 10000);
    }

}
