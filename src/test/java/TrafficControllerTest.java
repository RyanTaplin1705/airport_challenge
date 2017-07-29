import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrafficControllerTest {

    private TrafficController trafficController = new TrafficController();
    private Plane plane;
    private Airport airport;

    @Before
    public void setUp() throws Exception {
        givenWeHaveAnAirport();
        givenWeHaveAPlane();
    }

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionFromTrafficController();
    }

    private void thePlaneReceivesTheInstructionFromTrafficController() {
        verify(plane).land(airport);
    }

    private void whenTrafficControllerInstructsPlaneToLand() {
        trafficController.instructLand(plane, airport);
    }

    private void givenWeHaveAPlane() {
        plane = mock(Plane.class);
    }

    private void givenWeHaveAnAirport() {
        airport = mock(Airport.class);
    }
}