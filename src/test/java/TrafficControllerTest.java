import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrafficControllerTest {

    private TrafficController trafficController = new TrafficController();
    private Plane plane = mock(Plane.class);
    private Airport airport = mock(Airport.class);

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    @Test
    public void instructPlaneToDepartFromAirport() throws Exception {
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneReceivesTheInstructionToDepart();
    }

    private void whenTrafficControllerInstructsPlaneToDepart() {
        trafficController.instructDepart(plane);
    }

    private void whenTrafficControllerInstructsPlaneToLand() {
        trafficController.instructLand(plane, airport);
    }

    private void thePlaneReceivesTheInstructionToLand() {
        verify(plane).land(airport);
    }

    private void thePlaneReceivesTheInstructionToDepart() {
        verify(plane).depart();
    }
}