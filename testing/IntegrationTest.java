import ch.vehicles.tbz.VehicleController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class IntegrationTest {

    VehicleController vehicleController = new VehicleController();

    @Test
    public void switchCase_requestMethod_executeMethod() {
        assertFalse(vehicleController.switchCase("invalid"));
    }

}
