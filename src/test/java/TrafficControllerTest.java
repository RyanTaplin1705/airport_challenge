import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

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

        thePlaneConfirmsLanding();
        andAirportAcknowledgesArrivalOfThePlane();
    }

    private void andAirportAcknowledgesArrivalOfThePlane() {

    }

    private void thePlaneConfirmsLanding() {

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