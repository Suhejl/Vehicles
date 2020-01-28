import ch.vehicles.tbz.VehicleController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class tests that all classes can work together
 */
public class IntegrationTest {

    VehicleController vehicleController = new VehicleController();

    /**
     * negative test that tests that the switch case in VehicleCntroller works
     * It is accepted if we receive false as soon as an invalid entry is made
     */
    @Test
    public void switchCase_requestMethod_executeMethod() {
        assertFalse(vehicleController.switchCase("invalid"));
    }

}
