import ch.vehicles.tbz.Contract;
import ch.vehicles.tbz.VehicleService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This testing class test the VehicleService class and assures that everything works fine
 */
public class VehicleServiceTest {

    VehicleService vehicleService = new VehicleService("testing\\DummyData.csv");

    /**
     * As soon as a new contract is created and the cashamount is set the cashAmount in VehicleService gets adjusted
     * This test is accepted when cashAmount is increased by 2000 first, and lowered down to 10'000 later again
     */
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
